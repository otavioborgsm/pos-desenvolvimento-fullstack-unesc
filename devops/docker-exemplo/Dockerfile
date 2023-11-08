# Define a imagem base
FROM debian:latest
# Define o mantedor da imagem
LABEL maintainer="DevOps Unesc Pos"
# Atualiza imagem com os pacotes
RUN apt-get update && apt-get upgrade -y
# Instala o NGINX para testar
RUN apt-get install nginx -y
# Expoe a porta 80
EXPOSE 80
# Comando para iniciar o NGINX no Container
CMD ["nginx", "-g", "daemon off;"]