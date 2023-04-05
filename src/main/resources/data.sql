insert into endereco (id, rua, numero, complemento, cep) values (1, 'Rua A', 111, 'Apt 101', 22365889);
insert into endereco (id, rua, numero, complemento, cep) values (2, 'Rua B', 222, 'Apt 201', 22635788);
insert into endereco (id, rua, numero, complemento, cep) values (3, 'Rua C', 333, 'Apt 301', 22140589);
insert into endereco (id, rua, numero, complemento, cep) values (4, 'Rua D', 444, 'Apt 401', 23556871);
insert into endereco (id, rua, numero, complemento, cep) values (5, 'Rua E', 555, 'Apt 501', 23887352);
insert into endereco (id, rua, numero, complemento, cep) values (6, 'Rua F', 666, 'Apt 601', 23826452);

insert into aluno (id, numero, status, nome, endereco_id) values (1, 1680081123, 1, 'Joao', 1);
insert into aluno (id, numero, status, nome, endereco_id) values (2, 1680081234, 1, 'Maria', 2);
insert into aluno (id, numero, status, nome, endereco_id) values (3, 1680081345, 1, 'Ana', 3);
insert into aluno (id, numero, status, nome, endereco_id) values (4, 1680081456, 1, 'Marcos', 4);
insert into aluno (id, numero, status, nome, endereco_id) values (5, 1680081567, 1, 'Junior', 5);
insert into aluno (id, numero, status, nome, endereco_id) values (6, 1680081678, 1, 'Catarina', 6);

insert into professor (id, nome) values (1, 'Jose');
insert into professor (id, nome) values (2, 'Juliana');
insert into professor (id, nome) values (3, 'Otavio');

insert into curso (id, nome, professor_id) values (1, 'Java', 1);
insert into curso (id, nome, professor_id) values (2, 'React', 2);
insert into curso (id, nome, professor_id) values (3, 'Angular', 2);
insert into curso (id, nome, professor_id) values (4, 'JavaScript', 3);
insert into curso (id, nome, professor_id) values (5, 'Php', 1);

insert into aluno_curso (aluno_id, curso_id, av1, av2, nota_final, aprovado) values (1, 1, 5, 5, 0, 1);
insert into aluno_curso (aluno_id, curso_id, av1, av2, nota_final, aprovado) values (1, 3, 5, 5, 0, 1);
insert into aluno_curso (aluno_id, curso_id, av1, av2, nota_final, aprovado) values (1, 4, 5, 5, 0, 1);
insert into aluno_curso (aluno_id, curso_id, av1, av2, nota_final, aprovado) values (1, 5, 5, 5, 0, 1);
insert into aluno_curso (aluno_id, curso_id, av1, av2, nota_final, aprovado) values (2, 3, 5, 5, 0, 1);
insert into aluno_curso (aluno_id, curso_id, av1, av2, nota_final, aprovado) values (2, 4, 5, 5, 0, 1);
insert into aluno_curso (aluno_id, curso_id, av1, av2, nota_final, aprovado) values (3, 1, 5, 5, 0, 1);
insert into aluno_curso (aluno_id, curso_id, av1, av2, nota_final, aprovado) values (4, 4, 5, 5, 0, 1);
insert into aluno_curso (aluno_id, curso_id, av1, av2, nota_final, aprovado) values (5, 2, 5, 5, 0, 1);
insert into aluno_curso (aluno_id, curso_id, av1, av2, nota_final, aprovado) values (5, 4, 5, 5, 0, 1);
insert into aluno_curso (aluno_id, curso_id, av1, av2, nota_final, aprovado) values (6, 1, 5, 5, 0, 1);





