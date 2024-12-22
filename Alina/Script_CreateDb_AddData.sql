-- public.workers определение

-- Drop table

-- DROP TABLE workers;

CREATE TABLE workers(
	worker_id serial4 NOT NULL,
	position varchar(50) NOT NULL,
	first_name varchar(30) NOT NULL,
	second_name varchar(30) NOT NULL,
	middle_name varchar(30) NULL,
	CONSTRAINT workers_pk PRIMARY KEY (worker_id)
);

INSERT INTO public.workers (position, first_name, second_name, middle_name) VALUES
('Ювелир-модельер','Мерцлюк', 'Мария', 'Максимовна'),
('Сборщик заказов', 'Платонов', 'Руслан', 'Георгиевич'),
('Ювелир-модельер', 'Суворова', 'Эмилия', 'Михайловна'),
('Ювелир-изготовитель', 'Мельников', 'Серафим', 'Григорьевич'),
('Ювелир-модельер', 'Акимова', 'Мария', 'Егоровна'),
('Сборщик заказов', 'Крючкова', 'Малика', 'Семёновна'),
('Ювелир-изготовитель', 'Зуева', 'Ясмина', 'Романовна');

-- public.customers определение

-- Drop table

-- DROP TABLE customers;

CREATE TABLE customers(
	customer_id serial4 NOT NULL,
	first_name varchar(30) NOT NULL,
	second_name varchar(30) NOT NULL,
	middle_name varchar(30) NULL,
	phone varchar(20) NOT NULL,
	card_number varchar(16) NULL,
	email varchar(50) NOT NULL,
	"password" varchar(50) NOT NULL,
	CONSTRAINT customers_pk PRIMARY KEY (customer_id)
);

INSERT INTO public.customers (first_name, second_name, middle_name, phone, card_number, email,"password") VALUES

(N'Севастьянов', N'Ярослав', N'Даниилович', '89936141435', '3479395037593058', 'merce07@gmail.com', 'me1ce'),
(N'Новиков', N'Эмин', N'Леонидович', 89145374529, '3927503857619403', 'platon222@gmail.com', 'p1at0n'),
(N'Рубцова', N'Юлия', N'Степановна', '89764912114', '5764037594756003', 'syvor1@gmail.com', 'milashka2'),
(N'Тарасова', N'Алиса', N'Артёмовна', '89731356590', NULL, 'serafim7@gmail.com', 'gdchggxhy145'),
(N'Касаткина', N'Кира', N'Глебовна', '89215742295', '9374650274002814', 'mar1@gmail.com', 'mari209'),
(N'Никитин', N'Даниил', N'Васильевич', '89428920141', '4593058305830285', 'mal1k@gmail.com', 'kihpy14'),
(N'Николаева', N'Варвара', N'Ярославовна', '89863448678', NULL, 'zyeva006@gmail.com', 'zyedrtcg99 ');

-- public.delivery_methods определение

-- Drop table

-- DROP TABLE delivery_methods;

CREATE TABLE delivery_methods(
	delivery_method_id serial4 NOT NULL,
	title varchar(30) NOT NULL,
	description varchar(300) NOT NULL,
	"cost" numeric NOT NULL,
	CONSTRAINT delivery_methods_pk PRIMARY KEY (delivery_method_id)

);

INSERT INTO public.delivery_methods (title, description, "cost") VALUES
('Самовывоз', 'Остановка Детский мир', 0),
('Курьерская доставка', 'Тариф установлен', 150),
('В другие города', 'Почта России 1 класс', 350),
('В другие страны', 'Тариф установлен',3500);

-- public.gemstones определение

-- Drop table

-- DROP TABLE gemstones;

CREATE TABLE gemstones(
	gemstone_id serial4 NOT NULL,
	title varchar(50) NOT NULL,
	type_of_stone varchar(30) NOT NULL,
	color varchar(30) NOT NULL,	
	shape_of_the_cut varchar(30) NOT NULL,
	size varchar(30),
	CONSTRAINT gemstones_pk PRIMARY KEY (gemstone_id)
);

INSERT INTO public.gemstones (title, type_of_stone, color, shape_of_the_cut, size) VALUES
('Морганит', 'Полудрагоценный', 'Б/Ц', 'Груша', '7.00 х 5.00 мм' ),
('Шпинель', 'Полудрагоценный', 'Черный', 'Круг', '1.00 мм х 1.00 мм'),
('Турмалин', 'Полудрагоценный', 'Фиолетовый', 'Сердце', '12.50 х 12.90 х 6.10 мм'),
('Опал', 'Полудрагоценный', 'Белый', 'Фантазийная', '43.20 х 33.10 х 11.30 мм'),
('Фианит', 'Искусственный', 'Гранатовый', 'Круг', '2.00 мм х 2.00 мм'),
('Фианит', 'Искусственный', 'Б/Ц', 'Маркиз', '6.00 х 12.00 мм'),
('Гранат', 'Полудрагоценный', 'Пироп', 'Груша', '10.00 х 7.00 мм');

-- public.metals определение

-- Drop table

-- DROP TABLE metals;

CREATE TABLE metals(
	metal_id serial4 NOT NULL,
	title varchar(30) NOT NULL,
	sample varchar(3) NOT NULL,
	CONSTRAINT metals_pk PRIMARY KEY (metal_id)
);

INSERT INTO public.metals (title, sample) VALUES
('Золото', 375),
('Золото', 500),
('Золото', 585),
('Серебро', 916),
('Серебро', 925),
('Серебро', 960);

-- public.ring_sizes определение

-- Drop table

-- DROP TABLE ring_sizes;

CREATE TABLE ring_sizes(
	ring_size_id serial4 NOT NULL,
	size varchar(10) NOT NULL,
	CONSTRAINT ring_sizes_pk PRIMARY KEY (ring_size_id)
);

INSERT INTO public.ring_sizes (size) VALUES
(15),
(15.5),
(16),
(16.5),
(17),
(17.5),
(18),
(18.5),
(19),
(19.5),
(20),
(20.5),
(21);

-- public.products определение

-- Drop table

-- DROP TABLE products;

CREATE TABLE products(
	product_id  serial4 NOT NULL,
	title varchar(50) NOT NULL,
	type_product varchar(50) NOT NULL,
	description text NULL,
	metal_id int4 NOT NULL,
	gemstone_id int4 NULL,
	worker_id int4 NOT NULL,
	quantity_of_products int4 NULL,
	"cost" numeric NOT NULL,
	photo bytea NULL,
	CONSTRAINT products_pk PRIMARY KEY (product_id),
	CONSTRAINT products_metals_id_fk FOREIGN KEY (metal_id) REFERENCES metals(metal_id),
	CONSTRAINT products_gemstones_id_fk FOREIGN KEY (gemstone_id) REFERENCES gemstones(gemstone_id),
	CONSTRAINT products_worker_id_fk FOREIGN KEY (worker_id) REFERENCES workers(worker_id)
);

INSERT INTO public.products (title,type_product,description,metal_id,gemstone_id,worker_id,quantity_of_products,"cost",photo) VALUES
('me and you', 'подвеска', 'в комплекте с подвеской идет цепочка 50 см из латуни, покрыта родием. срок изготовления 7-10 рабочих дней. изделия могут немного отличаться от фотографии, это не тиражные работы и каждому мы уделяем особенное внимание.', 4, NULL, 1, 6, 4100.00,null),
('burning heart', 'кольцо', 'все изделия за исключением работ в наличии изготавливаются под заказ в вашем размере. срок изготовления 7-10 рабочих дней. изделия могут немного отличаться от фотографии, это не тиражные работы и каждому мы уделяем особенное внимание.', 6, 3, 4, 12, 9000.00,null),
('pointe', 'подвеска', 'в комплекте с подвеской идет цепочка 50 см из латуни, покрыта родием. срок изготовления 7-10 рабочих дней. изделия могут немного отличаться от фотографии, это не тиражные работы и каждому мы уделяем особенное внимание.', 1, NULL, 5, 6, 7000.00,null),
('lora', 'подвеска', 'в комплекте с подвеской идет цепочка 50 см из латуни, покрыта родием. срок изготовления 7-10 рабочих дней. изделия могут немного отличаться от фотографии, это не тиражные работы и каждому мы уделяем особенное внимание.', 1, NULL, 5, 6, 8000.00,null),
('INTERLACING', 'моно серьга', 'моно серьга сделанная в технике моделирования из воска, в виде серебряных нитей. срок изготовления 7-10 рабочих дней. изделия могут немного отличаться от фотографии, это не тиражные работы и каждому мы уделяем особенное внимание.', 1, NULL, 5, 10, 6000.00,null),
('CLEANING', 'средство для чистки изделий', 'способ применения— перед применением немного взболтать. налить средство в полимерную емкость. поместить изделие. оставить на 2-3 минуты. достать изделие, тщательно промыть водой и вытереть насухо. меры предосторожности — использовать только по назначению. не использовать для изделий с натуральными камнями. использовать перчатки. после использования тщательно вымыть руки.', NULL, NULL, 1, 4, 600.00,null);

-- public."orders" определение

-- Drop table

-- DROP TABLE "orders";


CREATE TABLE "orders"(
	order_id serial4 NOT NULL,
	customer_id int4 NOT NULL,
	product_id int4 NOT NULL,
	ring_size_id int4 NULL,
	quantity int4 NOT NULL,
	delivery_method_id int4 NOT NULL,
	delivery_address varchar(100) NULL,
	CONSTRAINT orders_pk PRIMARY KEY (order_id),
	CONSTRAINT orders_customer_id_fk FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
	CONSTRAINT orders_products_id_fk FOREIGN KEY (product_id) REFERENCES products(product_id),
	CONSTRAINT products_ring_size_id_fk FOREIGN KEY (ring_size_id) REFERENCES ring_sizes(ring_size_id),
	CONSTRAINT orders_delivery_methods_id_fk FOREIGN KEY (delivery_method_id) REFERENCES delivery_methods(delivery_method_id)
);

INSERT INTO public.orders (customer_id,product_id,ring_size_id,quantity,delivery_method_id,delivery_address) VALUES
( 1, 2, 3, 1, 1, NULL),
( 1, 1, null, 2, 2, 'Республика Марий Эл, Волжск, улица Гагарина, д.7, кв.54'),
( 2, 6, null, 1, 2, 'Республика Марий Эл, Волжск, улица Кошкина, д.56, кв.12'),
( 4, 6, null, 1, 4, '59, rue Le Roux 83115 Piresnec'),
( 7, 6, null, 1, 3, '140352, Владимирская область, город Дорохово, пр. Косиора 23, кв.56'),
( 6, 3, null, 2, 1, NULL),
( 1, 2, 4, 1, 3, '663362, Челябинская область, город Павловский Посад, пер. Славы 16, кв.9')
