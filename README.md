# AgendaSpringBoot
API REST para um CRUD (Create, Read, Update e Delete - em português Criar, Ler, Atualizar e Remover) utilizando Spring Boot 2, Hibernate, JPA e MySQL.

## API de Contatos que irá expor cinco métodos HTTP (URIs RESTFul) definidos abaixo:

* Listar todos os contatos - @GetMapping(“/contacts)

* Obter um contato específico pelo ID - @GetMapping(“/contacts/{id}”)

* Remover um contato pelo ID - @DeleteMapping(“/contacts/{id}”)

* Criar um novo contato - @PostMapping(“/contacts)

* Atualizar detalhes de um contato - @PutMapping(“/contacts/{id}”)
