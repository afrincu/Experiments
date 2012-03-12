<?
error_reporting(E_ALL);

$client_socket = stream_socket_client("tcp://fr1-alex.box.dinsoft.org:8000", $errno, $errstr);

if (!$client_socket)
{
	echo "$errstr ($errno)<br />\n";
} 
else 
{
	while(true)
	{	
		$content = trim(fgets($client_socket));
		echo "Got: " . $content . "\n";	

		$matches = array();
		if (preg_match("/^Client [^ ]+ said (.*)$/", $content, $matches))
		{
			$text = $matches[1];
			echo "$text\n";
			if ($text == "Bonjour")
			{
				fwrite($client_socket, "Bonjour\n");
			}
			elseif ($text == "time")
			{
				fwrite($client_socket, "The current time is " . time(). "\n");
			}
		}
	}
}
echo "hehe";
fclose($client_socket);
?>