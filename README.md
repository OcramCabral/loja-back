# CONFIGURAÇÃO

Daeeee, pessoal. Tudo beleza?

Segue as instruções para configurar o projeto.

------------
*Nossa API REST está com o Java 8, então certifique de ter essa versão instalada e configurada em seu computador. *

1) Clone o projeto e importe na sua IDE preferida.

2) Instale o plugin do Lombok na sua IDE. Obs: a dependência já está no projeto, instale somente o plugin.

- Eclipse: https://dicasdejava.com.br/como-configurar-o-lombok-no-eclipse/
- IntelliJ: https://dicasdejava.com.br/como-configurar-o-lombok-no-intellij-idea/

3) Buide o Maven.

4) **Esse quarto passo é opcional, mas é recomendado.** Por padrão, deixei a nossa API apontando para um banco em nuvem. Este banco é grátis e utilizado para testes, então em certos momentos pode ter instabilidade e lentidão. Então recomendo que utilize um banco local. O banco utilizado é o MySQL. Caso você já tenha um banco MySQL instalado em sua máquina, utilize esse banco mesmo, se não, vamos utilizar o XAMPP para facilitar nossa vida e ganhar tempo.

- Windows: https://mateusantunes.com/como-instalar-o-xampp-no-windows/
- Linux: https://pointcom.sampa.br/linux/como-instalar-o-xampp-no-ubuntu-20-04-lts/

Beleza, depois de instalado o XAMPP e iniciado o Apache e MySQL, vamos configurar o banco. Execute os seguintes scripts:

`CREATE DATABASE loja_db;` #Cria o banco de dados

`CREATE USER 'suporte_admin'@'localhost' IDENTIFIED BY '23e@!RTU.';` #Cria o usuário suporte_admin com a senha 23e@!RTU.

`GRANT ALL PRIVILEGES ON * . * TO 'suporte_admin'@'localhost';` #Adiciona todas permissões para o usuário suporte_admin

`FLUSH PRIVILEGES;` #Recarrega todos os privilégios dos usuários

Abra o arquivo *application.properties do projeto*, descomente a linha 5, comente a linha 4 e salve. Pronto! Nosso projeto já está pronto para rodar.

SÓ DAR O PLAY. Ele vai subir na porta 8080.

Segue o link do Swagger: http://localhost:8080/swagger-ui.html