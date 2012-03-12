<?
error_reporting(E_ALL);

$client_socket = stream_socket_client("tcp://irc.freenode.net:6667", $errno, $errstr);
$nickname = "alienfilou";
$realname = "the cat";
$channel = "#puisor";

fwrite($client_socket, "NICK $nickname\r\nUSER $nickname 0 * :$realname\r\n");

while(true)
{
	$content = fgets($client_socket);

	if (strpos($content, "001") !== FALSE)
	{
		fwrite($client_socket, "JOIN $channel\r\n");
		fwrite($client_socket, "PRIVMSG $channel :ce faci\r\n");		
	}
	elseif (strpos($content, "Bonjour") !== FALSE)
	{
		fwrite($client_socket, "PRIVMSG $channel :bonjour\r\n");
	}
	elseif (strpos($content, "time") !== FALSE)
	{
		fwrite($client_socket, "PRIVMSG $channel :The time is " . date('H:i:s') . "\r\n");
	}
}

fclose($client_socket);
?>
