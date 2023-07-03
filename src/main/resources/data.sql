insert	into public.tb_departamento(id, titulo)values(1, 'Financeiro') ON CONFLICT DO NOTHING;
insert	into public.tb_departamento(id, titulo)values(2, 'Comercial') ON CONFLICT DO NOTHING;
insert	into public.tb_departamento(id, titulo)values(3, 'Desenvolvimento') ON CONFLICT DO NOTHING;


 insert into public.tb_pessoa(id, nome, id_departamento) values (1, 'Camila', 1) ON CONFLICT DO NOTHING;
 insert into public.tb_pessoa(id, nome, id_departamento) values (2, 'Pedro', 2) ON CONFLICT DO NOTHING;
 insert into public.tb_pessoa(id, nome, id_departamento) values (3, 'Fabiano', 3) ON CONFLICT DO NOTHING;
 insert into public.tb_pessoa(id, nome, id_departamento) values (4, 'Raquel', 3) ON CONFLICT DO NOTHING;
 insert into public.tb_pessoa(id, nome, id_departamento) values (5, 'Patricia', 3) ON CONFLICT DO NOTHING;
 insert into public.tb_pessoa(id, nome, id_departamento) values (6, 'Joaquim', 1) ON CONFLICT DO NOTHING;
 
 insert into public.tb_tarefa (id, titulo, descricao, prazo, duracao, finalizada, id_departamento, id_pessoa)
values (1001, 'Validar NF Janeiro', 'Validar notas recebidas no mês de Janeiro','2023-02-15', 14, true, 1, 1) ON CONFLICT DO NOTHING;

insert into public.tb_tarefa (id, titulo, descricao, prazo, duracao, finalizada, id_departamento, id_pessoa)
values (1002, 'Bug 352', 'Corrigir bug 352 na versão 1.25','2023-05-10', 25, false, 3, null) ON CONFLICT DO NOTHING;

insert into public.tb_tarefa (id, titulo, descricao, prazo, duracao, finalizada, id_departamento, id_pessoa)
values (1003, 'Liberação da versão 1.24', 'Disponibilizar pacote para testes','2023-02-02', 2, false, 3, 3) ON CONFLICT DO NOTHING;

insert into public.tb_tarefa (id, titulo, descricao, prazo, duracao, finalizada, id_departamento, id_pessoa)
values (1004, 'Reunião A', 'Reunião com cliente A para apresentação do produto','2023-02-05', 5, false, 2, null) ON CONFLICT DO NOTHING;

insert into public.tb_tarefa (id, titulo, descricao, prazo, duracao, finalizada, id_departamento, id_pessoa)
values (1005, 'Reunião final', 'Fechamento contrato','2023-03-28', 6, false, 2, null) ON CONFLICT DO NOTHING;

insert into public.tb_tarefa (id, titulo, descricao, prazo, duracao, finalizada, id_departamento, id_pessoa)
values (1006, 'Pagamento 01/2022', 'Realizar pagamento dos fornecedores','2023-01-31', 6, true, 1, 1) ON CONFLICT DO NOTHING;

insert into public.tb_tarefa (id, titulo, descricao, prazo, duracao, finalizada, id_departamento, id_pessoa)
values (1007, 'Bug 401', 'Corrigir bug 401 na versão 1.20','2023-02-01', 2	, true, 3, 4) ON CONFLICT DO NOTHING;

insert into public.tb_tarefa (id, titulo, descricao, prazo, duracao, finalizada, id_departamento, id_pessoa)
values (1008, 'Bug 399', 'Corrigir bug 399 na versão 1.20','2023-01-28', 6	, true, 3, 5) ON CONFLICT DO NOTHING;

insert into public.tb_tarefa (id, titulo, descricao, prazo, duracao, finalizada, id_departamento, id_pessoa)
values (1009, 'Reunião B', 'Reunião com cliente B para apresentação do produto','2023-01-31', 5	, true, 2, 2) ON CONFLICT DO NOTHING;

insert into public.tb_tarefa (id, titulo, descricao, prazo, duracao, finalizada, id_departamento, id_pessoa)
values (1010, 'Validar NF Fevereiro', 'Validar notas recebidas no mês de Fevereiro','2023-03-15', 14 , false , 1, 6) ON CONFLICT DO NOTHING;


