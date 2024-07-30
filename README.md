A solução desenvolvida possui projetos front e backend e utiliza Spring Batch para o processamento de um arquivo CNAB e exibe os seus lançamentos importados em uma interface SPA com React.

# Tecnologias 

* Spring Boot
* Spring MVC
* Spring Data JDBC
* Spring Batch
* Vite
* React
* Tailwind
* PostgreSQL

# Como Executar

A executação deve ser feita com o Docker Compose, caso desejado, é possível executar cada projeto manualmente e localmente seguindo as instruções de seus respectivos arquivos README.

* Clonar repositório git:
```
git clone https://github.com/CiceroLucas/payments-backend.git
```

* Executar o script de inicialização:
```
chmod +x start.sh
./start.sh
```

* Acessar aplicação em http://localhost:9090. O arquivo de upload a ser usado deve ser no formato CNAB, anexado em files.

## Ambiente

Os projetos foram publicados no Render e o sistema pode ser acessado <a target="_blank" href="https://payments-frontend-f5tk.onrender.com">nesse link</a>.

# Decisões de Arquitetura

* O controle de unicidade das transações é feito por arquivo CNAB, o que significa que o processamento das transações é feito apenas uma vez por arquivo.
* O arquivo CNAB deve ser nomeado com um id ou timestamp, pois ele será passado como parâmetro do job e só pode ser importado uma única vez.
* Caso seja informado um arquivo já importado, deve ser informada uma mensagem de erro ao usuário.
* Caso haja erro no processamento é possível submeter o mesmo arquivo várias vezes para habilitar o restart de onde o processamento parou.
* Se o arquivo for muito grande, é possível utilizar uma estratégia de particionamento no job, melhorando assim a performance.
