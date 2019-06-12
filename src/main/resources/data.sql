
------	###	OS DADOS ABAIXO NÃO PODEM IR PARA PRODUÇÃO	###	------

--- clientes ---
--- não insere datas de nascimento e de cadastro
INSERT INTO tb_cliente (id_cliente, nome, cpf, instagram, facebook, email) VALUES ('b0e833f0-8d06-11e9-bc42-526af7764f64', 'Sarah Evelyn Silva', '23234054703', 'sara_es', null, null);
INSERT INTO tb_cliente (id_cliente, nome, cpf, instagram, facebook, email) VALUES ('b0e8368e-8d06-11e9-bc42-526af7764f64', 'Rebeca Jaqueline Melo', '64362804307', 'rebecamelo', 'rebecamelo', null );
INSERT INTO tb_cliente (id_cliente, nome, cpf, instagram, facebook, email) VALUES ('b0e837d8-8d06-11e9-bc42-526af7764f64', 'Pietra Rita Assis', '22860007946', 'PitAssis_', null, 'pietraritaassis__pietraritaassis@unimedsjc.com.br' );
INSERT INTO tb_cliente (id_cliente, nome, cpf, instagram, facebook, email) VALUES ('b0e83904-8d06-11e9-bc42-526af7764f64', 'Valentina Esther Fernandes', '25527765311', null, 'thether', 'valentinaestherfernandes_@raffinimobiliario.com.br' );
INSERT INTO tb_cliente (id_cliente, nome, cpf, instagram, facebook, email) VALUES ('b0e83f62-8d06-11e9-bc42-526af7764f64', 'Ricardo Bernardo da Silva', '61955426872', null, 'Ricnardo', 'ricardobernardodasilva_@sfreitasadvogados.com.br' );

--- telefones ---
INSERT INTO tb_telefone (id_telefone, ddd, numero, whatsapp, observacao, id_cliente_fk) VALUES ('62c479c2-8d0b-11e9-bc42-526af7764f64', 83, '32356050', 'FALSE', 'trabalho fds', 'b0e833f0-8d06-11e9-bc42-526af7764f64');
INSERT INTO tb_telefone (id_telefone, ddd, numero, whatsapp, observacao, id_cliente_fk) VALUES ('62c47c60-8d0b-11e9-bc42-526af7764f64', 83, '996185740', 'TRUE', null, 'b0e8368e-8d06-11e9-bc42-526af7764f64');
INSERT INTO tb_telefone (id_telefone, ddd, numero, whatsapp, observacao, id_cliente_fk) VALUES ('62c48160-8d0b-11e9-bc42-526af7764f64', 83, '990690637', 'FALSE', null, 'b0e837d8-8d06-11e9-bc42-526af7764f64');
INSERT INTO tb_telefone (id_telefone, ddd, numero, whatsapp, observacao, id_cliente_fk) VALUES ('62c482be-8d0b-11e9-bc42-526af7764f64', 83, '32354900', 'FALSE', null, 'b0e83904-8d06-11e9-bc42-526af7764f64');
INSERT INTO tb_telefone (id_telefone, ddd, numero, whatsapp, observacao, id_cliente_fk) VALUES ('62c483ea-8d0b-11e9-bc42-526af7764f64', 83, '35122009', 'FALSE', 'Ramal trabalho', 'b0e83f62-8d06-11e9-bc42-526af7764f64');
INSERT INTO tb_telefone (id_telefone, ddd, numero, whatsapp, observacao, id_cliente_fk) VALUES ('62c4850c-8d0b-11e9-bc42-526af7764f64', 83, '997916971', 'TRUE', null, 'b0e83904-8d06-11e9-bc42-526af7764f64');
INSERT INTO tb_telefone (id_telefone, ddd, numero, whatsapp, observacao, id_cliente_fk) VALUES ('62c4862e-8d0b-11e9-bc42-526af7764f64', 27, '28119059', 'FALSE', null, 'b0e83f62-8d06-11e9-bc42-526af7764f64');

--- enderecos ---
INSERT INTO tb_endereco (id_endereco, rua, numero, bairro, complemento, id_cliente_fk) VALUES ('0916cc7a-8d2b-11e9-bc42-526af7764f64','Rua Estudante Júlio Cezar Soares da Silva', '287', 'Valentina de Figueiredo', null, 'b0e833f0-8d06-11e9-bc42-526af7764f64');
INSERT INTO tb_endereco (id_endereco, rua, numero, bairro, complemento, id_cliente_fk) VALUES ('0916cf04-8d2b-11e9-bc42-526af7764f64','Rua Severina de Freitas', '362', 'Mandacaru', null, 'b0e8368e-8d06-11e9-bc42-526af7764f64');
INSERT INTO tb_endereco (id_endereco, rua, numero, bairro, complemento, id_cliente_fk) VALUES ('0916d044-8d2b-11e9-bc42-526af7764f64','Rua Francisco Guimarães', '650', 'Ipês', null, 'b0e837d8-8d06-11e9-bc42-526af7764f64');
INSERT INTO tb_endereco (id_endereco, rua, numero, bairro, complemento, id_cliente_fk) VALUES ('0916d42c-8d2b-11e9-bc42-526af7764f64','Rua Aluísio Bezerra da Silva', '207', 'Portal do Sol', null, 'b0e83904-8d06-11e9-bc42-526af7764f64');
INSERT INTO tb_endereco (id_endereco, rua, numero, bairro, complemento, id_cliente_fk) VALUES ('0916d594-8d2b-11e9-bc42-526af7764f64','Rua Valdemiro Ferreira da Silva', '819', 'Nações', null, 'b0e83f62-8d06-11e9-bc42-526af7764f64');
INSERT INTO tb_endereco (id_endereco, rua, numero, bairro, complemento, id_cliente_fk) VALUES ('0916d6c0-8d2b-11e9-bc42-526af7764f64','Rua Professor Oswaldo de Miranda Pereira', '623', 'Brisamar', null, 'b0e83904-8d06-11e9-bc42-526af7764f64');
INSERT INTO tb_endereco (id_endereco, rua, numero, bairro, complemento, id_cliente_fk) VALUES ('0916d7ec-8d2b-11e9-bc42-526af7764f64','Rua Aparecida', '690', 'Nova Conquista', null, 'b0e83f62-8d06-11e9-bc42-526af7764f64');
INSERT INTO tb_endereco (id_endereco, rua, numero, bairro, complemento, id_cliente_fk) VALUES ('0916dbac-8d2b-11e9-bc42-526af7764f64','Rua Maria Eulina', '110', 'Popular', null, 'b0e833f0-8d06-11e9-bc42-526af7764f64');

------	###	OS DADOS ACIMA NÃO PODEM IR PARA PRODUÇÃO	###	------







--- tamanhos ---

INSERT INTO tb_tamanho (id_tamanho, nome, centimetros, numero_fatias, numero_maximo_sabores,preco_padrao) VALUES ('d134a92e-889f-11e9-bc42-526af7764f64','Pequena', 25, 4, 1,17);
INSERT INTO tb_tamanho (id_tamanho, nome, centimetros, numero_fatias, numero_maximo_sabores,preco_padrao) VALUES ('d134aba4-889f-11e9-bc42-526af7764f64','Média', 30, 6, 2, 22);
INSERT INTO tb_tamanho (id_tamanho, nome, centimetros, numero_fatias, numero_maximo_sabores,preco_padrao) VALUES ('d134ace4-889f-11e9-bc42-526af7764f64','Grande', 35, 8, 3, 29);
INSERT INTO tb_tamanho (id_tamanho, nome, centimetros, numero_fatias, numero_maximo_sabores,preco_padrao) VALUES ('d134ae10-889f-11e9-bc42-526af7764f64','Gigante', 40, 12, 3, 40);

--- recheios ---

INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5facf00-8a2e-11e9-bc42-526af7764f64', 'Abacaxi', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fad176-8a2e-11e9-bc42-526af7764f64', 'Alho Torrado', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fad2ca-8a2e-11e9-bc42-526af7764f64', 'Atum', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fad400-8a2e-11e9-bc42-526af7764f64', 'Azeitona', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fad7fc-8a2e-11e9-bc42-526af7764f64', 'Azeitonas Fatiadas', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fad95a-8a2e-11e9-bc42-526af7764f64', 'Bacalhau Desfiado', true, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fada86-8a2e-11e9-bc42-526af7764f64', 'Bacon', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fadba8-8a2e-11e9-bc42-526af7764f64', 'Banana', false, true, false);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fadcca-8a2e-11e9-bc42-526af7764f64', 'Batata Palha', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fade46-8a2e-11e9-bc42-526af7764f64', 'Beijinho', false, true, false);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fadf72-8a2e-11e9-bc42-526af7764f64', 'Brócolis', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fae332-8a2e-11e9-bc42-526af7764f64', 'Calabresa', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fae47c-8a2e-11e9-bc42-526af7764f64', 'Calabresa Triturada', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fae5b2-8a2e-11e9-bc42-526af7764f64', 'Camarão', true, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fae6d4-8a2e-11e9-bc42-526af7764f64', 'Canela', false, true, false);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fae7f6-8a2e-11e9-bc42-526af7764f64', 'Carne De Sol', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fae918-8a2e-11e9-bc42-526af7764f64', 'Carne Moída', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5faea3a-8a2e-11e9-bc42-526af7764f64', 'Cebola', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5faedbe-8a2e-11e9-bc42-526af7764f64', 'Chanpignon', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5faef12-8a2e-11e9-bc42-526af7764f64', 'Cheddar', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5faf03e-8a2e-11e9-bc42-526af7764f64', 'Chocolate Cremoso', false, true, false);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5faf160-8a2e-11e9-bc42-526af7764f64', 'Chocolate Em Pó', false, true, false);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5faf282-8a2e-11e9-bc42-526af7764f64', 'Chocolate Granulado', false, true, false);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5faf3a4-8a2e-11e9-bc42-526af7764f64', 'Côco Ralado', false, true, false);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5faf606-8a2e-11e9-bc42-526af7764f64', 'Cream Cheese', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5faf9c6-8a2e-11e9-bc42-526af7764f64', 'Creme De Camarão', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fafb10-8a2e-11e9-bc42-526af7764f64', 'Doce De Leite', false, true, false);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fafca0-8a2e-11e9-bc42-526af7764f64', 'Ervilha', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fafdd6-8a2e-11e9-bc42-526af7764f64', 'Figo', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5faff0c-8a2e-11e9-bc42-526af7764f64', 'Frango', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb0038-8a2e-11e9-bc42-526af7764f64', 'Goiabada Cremosa', false, true, false);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb0448-8a2e-11e9-bc42-526af7764f64', 'Gorgonzola', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb05a6-8a2e-11e9-bc42-526af7764f64', 'Leite Condensado', false, true, false);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb06c8-8a2e-11e9-bc42-526af7764f64', 'Lombo Fatiado', true, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb07f4-8a2e-11e9-bc42-526af7764f64', 'Manjericão Verde', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb0920-8a2e-11e9-bc42-526af7764f64', 'Milho', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb0a60-8a2e-11e9-bc42-526af7764f64', 'Molho', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb0b8c-8a2e-11e9-bc42-526af7764f64', 'Mussarela', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb0ee8-8a2e-11e9-bc42-526af7764f64', 'Orégano', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb1028-8a2e-11e9-bc42-526af7764f64', 'Ovos', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb115e-8a2e-11e9-bc42-526af7764f64', 'Palmito', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb1280-8a2e-11e9-bc42-526af7764f64', 'Parmesão', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb13a2-8a2e-11e9-bc42-526af7764f64', 'Peito De Peru', true, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb179e-8a2e-11e9-bc42-526af7764f64', 'Peperoni', true, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb18f2-8a2e-11e9-bc42-526af7764f64', 'Pêssego', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb1a14-8a2e-11e9-bc42-526af7764f64', 'Pimentão', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb1b36-8a2e-11e9-bc42-526af7764f64', 'Presunto', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb1c4e-8a2e-11e9-bc42-526af7764f64', 'Provolone', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb1e4c-8a2e-11e9-bc42-526af7764f64', 'Requeijão', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb1fb4-8a2e-11e9-bc42-526af7764f64', 'Rúcula', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb2342-8a2e-11e9-bc42-526af7764f64', 'Salsicha', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb248c-8a2e-11e9-bc42-526af7764f64', 'Tiras De Filé', true, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb25b8-8a2e-11e9-bc42-526af7764f64', 'Tomate', false, true, true);
INSERT INTO tb_recheio (id_recheio, nome, eh_especial, eh_disponivel, eh_salgado) VALUES ('a5fb26da-8a2e-11e9-bc42-526af7764f64', 'Tomate Seco', false, true, true);