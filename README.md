# sd_middleware

Projeto de Sistemas Distribuídos com Middleware

O projeto consiste na implementação de uma aplicação onde um cliente Android solicita a formatação de um texto em duas formas, concatenada e em letras maiúsculas de um serviço. Cada serviço específico fica hospedado em um servidor diferente que receberão a requisição do middleware, que primeiramente recebe a requisição do cliente.

O cliente envia um texto para o middleware através de uma conexão RESTful, o middleware envia o mesmo texto para cada servidor também através de uma conexão RESTful, cada servidor formata o texto e retorna para o middleware, quando o middleware recebe os dois textos nos devidos formatos ele retorna para o cliente.

Todas as conexões são feitas com Threads.
