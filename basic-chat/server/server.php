<?
/*Create a domain socket server*/
$socket = stream_socket_server("tcp://0.0.0.0:8000", $errno, $errstr);

 if (!$socket) {
  echo "$errstr ($errno)<br />\n";
} else {
	
  while ($conn = stream_socket_accept($socket)) {
	do{
		$contents = trim(fgets($conn));
		fwrite($conn, 'You said:' . $contents ."\r\n");
		
		} while($contents != "Bye!");
	
	fclose($conn);
  }
  fclose($socket);
  }
?>