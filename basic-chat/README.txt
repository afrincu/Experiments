In order to build a basic chat with PHP socket programming the server side needs to be created as long with the client side.

There are steps to follow in network socket programming:

1. On the server side:

- create file descriptor/ socket with the function stream_socket_server();
- accept a connection to the created socket (stream_socket_accept())
- read - fgets() gets line by line
- write - fwrite()
- close the connection, fclose()

2. On the client side:

- create socket
- read and write
- close socket

A series of these functions are blocking ones: fgets, accept, and they have to be dealt with carrefully.


The client.php creates a client that connects to aserver, 
listens to what it is said, and in case the message is 'Bonjour' it replies with 'Bonjour'.
If the message is 'time' it will send the current time.


The server.php builds a server that repeats to the client what she (the client) said to the server. 
If the client sents 'Bye!', then the server decides to close the connection.

server_multi.php is a server which deals with multiple connections at the same time.
It identifies the clients, depending on their IP address, and broadcasts to the other connections 
when a client has just connected and what a connected client said.