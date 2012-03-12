<?
error_reporting(E_ALL);

function asmanybytes($handle, $number)
{
	$content = "";
	do
	{
		$content .= fread($handle, $number - strlen($content));
	}
	while(strlen($content) < $number);
	return $content;
}

$europafm = '89.238.252.146:7000';
$top40uk = 'relay.181.fm:8070';

$server = $top40uk;

$client_socket = stream_socket_client("tcp://$server", $errno, $errstr);

fwrite($client_socket, "GET / HTTP/1.1\r\n");
fwrite($client_socket, "Host: $server\r\n");
fwrite($client_socket, "User-Agent: Puisor media player\r\n");
fwrite($client_socket, "Range: bytes=0-.\r\n");
fwrite($client_socket, "Icy-MetaData: 1\r\n");
fwrite($client_socket, "\r\n");

do
{
	$header = trim(fgets($client_socket));
	echo "the header line is $header\r\n";
	if (strpos($header, "content-type")!== false)
	{
		$content_type = substr($header, 19, strlen ($header) - strpos($header, "/" ));
		echo "The encoding is $content_type\n";
	}
	elseif(strpos($header, "metaint")!== false)
	{
		$interval = substr($header, 12, strlen ($header) - strpos($header, ":" ));
		echo "The metadata interval is $interval\n";
	}	
}
while (!empty($header));


$handle_song = NULL;
$i = 1;
while($i <= 50)
{
	$content = asmanybytes($client_socket, $interval);
	if ($handle_song !== NULL)
		{
			fwrite($handle_song, $content);
		}	
	echo "The length of sound is " . strlen($content) . "\n";
	$length_byte = asmanybytes($client_socket, 1);
	
	
				
			if (ord($length_byte) == 0)
			{
				echo "There is no metadata available\n";	
			}
			else 
			{
				$metadata = asmanybytes($client_socket, ord($length_byte)*16);
				echo "The data is $metadata\n";
				$title = substr($metadata, 13, strpos($metadata, ';') - 13 - 1);
				echo "The title song is $title\n";
				$array = {'/', '\', ':', '?', '*', '<', '>', '"', '|'};
				$title = str_replace($array, "0", $title);
				
				
				if($content_type == "mpeg")
				{
					$filename = "$title.mp3";
				}
				elseif($content_type == "aacp")
				{
					$filename = "$title.aac";
				}	
				$handle_song = fopen($filename, 'w');		
			}	
			
		
	}
			
$i++;
fclose($handle_song);
	
fclose($client_socket);
?>