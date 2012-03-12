<?
function list_clients($clients, $current_socket) 
{
	$nb_clients = count($clients);
	fwrite($current_socket, "There are $nb_clients clients connected: \r\n"); 
	for ($j = 0; $j < count($clients); $j++)
	{
		$name = stream_socket_get_name($clients[$j], true);
		fwrite($current_socket, "  $name\r\n");
	}
}

$clients = array();
$server = stream_socket_server("tcp://0.0.0.0:8000", $errno, $errstr);

while (true)
{ 
	$read = $clients;
	$read[] = $server;
	$null = array();

	$nb_changes = stream_select($read, $null, $null, null);
	
	for($i = 0; $i < count($read); $i++)
	{
		if ($read[$i] == $server)
		{
			$client = stream_socket_accept($server);
			$clients[] = $client;
			echo "Client " . stream_socket_get_name($client, true) . " is connected\n";
			list_clients($clients, $client);
		}
		else
		{
			$f = fgets($read[$i]);
			if($f !== FALSE)
			{
				$content = trim($f);	
				$name = stream_socket_get_name($read[$i], true);	
				echo "Client $name said $content\n";
				
				for($j = 0; $j < count($clients); $j++)
				{
					if ($clients[$j] != $read[$i])
					{
						fwrite($clients[$j], "Client $name said $content\r\n");
					}
				}
			}
			else
			{
				$name = stream_socket_get_name($read[$i], true);	
				echo "Client $name disconnected\r\n";
				for ($j = 0; $j < count($clients); $j++)
				{
					if ($clients[$j] == $read[$i])
					{
						unset($clients[$j]);
						$clients = array_values($clients);
					}	
					
				}
				fclose($read[$i]);
			}
		}
	}	
}

fclose($socket);
?>
