# Nome do Projeto
**Imobly**  

---

## Nome do Grupo
Grupo: Imobly-project 

## Integrantes
- Ana Luiza dos Santos Dias
- Fabio Monte Alves
- Gustavo Simões Lisboa
- João Vitor Moreira dos Santos Neris

---

## Descrição do Projeto
O projeto Imobly é uma aplicação multiplataforma para o gerenciamento de locação de imóveis. 
O projeto busca criar uma ferramenta personalizada capaz de centralizar informações sobre imóveis, 
inquilinos e contratos, além de otimizar processos administrativos e facilitar o controle de pagamentos, prazos e manutenção. 
Para isso, utilizamos o serviço da Amazon Web Services (AWS) com o serviço S3, Docker, Kotlin, Kotlin Multiplataforma e Spring Boot. 
A aplicação foi projetada para funcionar em plataformas web, desktop e mobile.


---

## Tecnologias Utilizadas
- **Front-end:** Kotlin, Kotlin Multiplataforma(KMP), JetPack Compose, Ktor e Material Design 3 
- **Back-end:** Kotlin, Spring Boot 
- **Banco de Dados:** PostgreSQL 
- **Infraestrutura e serviços de terceiros:** Upload de imagens(AWS S3) e Docker

---

## YouTube

- [Assista ao vídeo](https://youtu.be/sZ6s6SD_Nis)

---

## Instalação e Execução

### Pré-requisitos
- Docker
- Java 21

### Back-end
1. Clone o repositório:  
```
git clone https://github.com/Imobly-Project/imobly-back-end.git
```

2. Crie um container para o banco de dados:
```
docker run -d -p 5432:5432 --name postgres-imobly -e POSTGRES_PASSWORD=root -e POSTGRES_USER=root -e POSTGRES_DB=database-imobly postgres:17
```

3. Abra o arquivo imobly_keys.txt e copie todo seu conteudo.

4. Cole o conteúdo copiado do arquivo imobly_keys.txt na configuração de execução do projeto (Run → Edit Configurations...) dentro de “Environment Variables”..

5. Execute a aplicação (Garanta que não há outro serviço rodando na porta 8080):
```
./gradlew bootRun
```

### Front-ends - Locatário e Locador
1. Clone o repositório:  
```
git clone https://github.com/Imobly-Project/imobly-front-end-landlord.git
```
ou
```
git clone https://github.com/Imobly-Project/imobly-front-end-tenant.git
```


2. Em "composeApp/src/commonMain/kotlin/com/imobly/imobly/api/HttpClientManager.kt", troque o IP do arquivo para o IP da sua máquina (Use o comando ipconfig ou ifconfig dependendo do seu sistema operacional):
```
url {
            protocol = URLProtocol.HTTP
            port = 8080 
            host = "XXX.XXX.XXX.XXX" <- troque para o IP da sua máquina
        }
```

3. Agora em "composeApp/src/androidMain/res/xml/network_security_config.xml", troque o IP do arquivo para o IP da sua máquina:
```
<domain includeSubdomains="true">"XXX.XXX.XXX.XXX"</domain>
```

4. Execute o projeto (Ao rodar em outro dispositivo, certifique-se de que este está em conectado na mesma rede no qual está conectado o servidor):
-JVM (Desktop)
```
.\gradlew.bat :composeApp:run
```

-Web
```
.\gradlew.bat :composeApp:jsBrowserDevelopmentRun
```

-Android
```
.\gradlew.bat :composeApp:assembleDebug
```
