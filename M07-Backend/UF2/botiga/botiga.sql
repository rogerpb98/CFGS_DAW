DROP DATABASE IF EXISTS botiga;
CREATE DATABASE IF NOT EXISTS botiga;
drop user if exists 'roger'@'localhost';
create user 'roger'@'localhost' identified by 'roger';
GRANT ALL PRIVILEGES ON *.* TO 'roger'@'localhost';
use botiga;

DROP TABLE IF EXISTS PRODUCTO;
DROP TABLE IF EXISTS CLIENTE;

CREATE TABLE CLIENTE(
    USER VARCHAR(25) primary key,
    PASSWORD VARCHAR(255) NOT NULL,
	NOMBRE VARCHAR(25) NOT NULL,
    APELLIDO VARCHAR(25)
);

CREATE TABLE PRODUCTO(
	ID INT AUTO_INCREMENT,
	NOMBRE VARCHAR(70) NOT NULL,
    CATEGORIA ENUM('Juegos', 'Consolas', 'Perifericos') NOT NULL,
    DESCRIPCION VARCHAR(255) NOT NULL,
	PRECIO float NOT NULL,
	FOTO1 varchar(255),
    FOTO2 varchar(255),
    FOTO3 varchar(255),
    PUBLICATION_DATE DATE NOT NULL DEFAULT CURDATE(),
    VISITED INT DEFAULT 0,

    CLIENTE_USER VARCHAR(25) NOT NULL,

    PRIMARY KEY (ID),
    CONSTRAINT FK_PROP_CLIENTE FOREIGN KEY (CLIENTE_USER) REFERENCES CLIENTE(USER)
);
/*INSERTS CLIENTE*/
INSERT INTO CLIENTE (USER, PASSWORD, NOMBRE) VALUES ('GuillermoTel','1234','Guillermo');
INSERT INTO CLIENTE (USER, PASSWORD, NOMBRE) VALUES ('AmanteDeLosPozos','1234','Julen');
INSERT INTO CLIENTE VALUES ('meloguiso','1234','Juan','Palomo');
INSERT INTO CLIENTE VALUES ('antonia44','1234','Antonia','Guarnizo');
/*INSERTS PRODUCTO*/
INSERT INTO PRODUCTO (PUBLICATION_DATE, NOMBRE, CATEGORIA, DESCRIPCION, PRECIO, FOTO1, CLIENTE_USER) VALUES ('2021-12-21','MSI Vigor GK20','Perifericos','El teclado gaming MSI Vigor GK20 con un diseño ergonómico con teclas de forma cóncava para una experiencia de escritura y juego más cómoda.',19.98, 'https://thumb.pccomponentes.com/w-530-530/articles/33/330039/1868-msi-vigor-gk20-teclado-gaming-retroiluminado.jpg', 'AmanteDeLosPozos');
INSERT INTO PRODUCTO (PUBLICATION_DATE, NOMBRE, CATEGORIA, DESCRIPCION, PRECIO, FOTO1, CLIENTE_USER) VALUES ('2021-07-12','Aukey KM-G14','Perifericos','Este teclado mecánico compacto "sin teclas" (sin teclado numérico) permite ahorrar, una experiencia de escritura eficiente y satisfactoria en la oficina o en el hogar.',34.99, 'https://thumb.pccomponentes.com/w-530-530/articles/42/421688/1419-aukey-km-g14-teclado-mecanico-gaming-rgb-switch-blue.jpg', 'GuillermoTel');
INSERT INTO PRODUCTO (PUBLICATION_DATE, NOMBRE, CATEGORIA, DESCRIPCION, PRECIO, FOTO1, CLIENTE_USER) VALUES ('2021-09-30','Razer Huntsman Tournament Edition','Perifericos','Una fracción de segundo puede suponer la victoria, por eso la velocidad es clave en el teclado Razer Huntsman Tournament Edition.',99.99, 'https://thumb.pccomponentes.com/w-530-530/articles/35/350528/1924-razer-huntsman-tournament-edition-teclado-mecanico-gaming-rgb-switch-optico-lineal-foto.jpg', 'antonia44');
INSERT INTO PRODUCTO (PUBLICATION_DATE, NOMBRE, CATEGORIA, DESCRIPCION, PRECIO, FOTO1, CLIENTE_USER) VALUES ('2021-02-27','Newskill Serike','Perifericos','Para los amantes de los teclados mecánicos compactos, en Newskill os presentamos a Serike. Un teclado con una propuesta RGB en la que destaca un aura de retroiluminación en sus laterales y que va recorriendo todas sus teclas.',53.70, 'https://thumb.pccomponentes.com/w-530-530/articles/24/249940/serike.jpg', 'meloguiso');
INSERT INTO PRODUCTO (PUBLICATION_DATE, NOMBRE, CATEGORIA, DESCRIPCION, PRECIO, FOTO1, CLIENTE_USER) VALUES ('2021-07-25','Logitech G203','Perifericos','Aprovecha al máximo tu tiempo de juego con el ratón G203 2nd Gen para gaming, con tecnología LIGHTSYNC, un sensor para gaming y un diseño clásico con 6 botones. Anima tu juego... y tu escritorio.',19.82, 'https://thumb.pccomponentes.com/w-530-530/articles/28/287353/logitech-g203-lightsync-2nd-gen-raton-gaming-8000dpi-rgb-negro.jpg', 'AmanteDeLosPozos');
INSERT INTO PRODUCTO (PUBLICATION_DATE, NOMBRE, CATEGORIA, DESCRIPCION, PRECIO, FOTO1, CLIENTE_USER) VALUES ('2021-05-21','Logitech Pro X Superlight','Perifericos','Elimina todos los obstáculos para ganar con el ratón inalámbrico Logitech Pro X Superlight más ligero y rápido.',113.97, 'https://thumb.pccomponentes.com/w-530-530/articles/35/351240/158-logitech-pro-x-superlight-raton-gaming-25400dpi-negro.jpg', 'GuillermoTel');
INSERT INTO PRODUCTO (PUBLICATION_DATE, NOMBRE, CATEGORIA, DESCRIPCION, PRECIO, FOTO1, CLIENTE_USER) VALUES ('2021-12-16','Logitech G Pro','Perifericos','PRO Wireless está pensado para ser el ratón para gaming definitivo para los profesionales de eSports.',100.28, 'https://thumb.pccomponentes.com/w-530-530/articles/17/179966/1985-logitech-g-pro-raton-gaming-inalambrico-16000dpi-negro-981d7593-deb5-47b1-9968-cb4549f1e958.jpg', 'antonia44');
INSERT INTO PRODUCTO (PUBLICATION_DATE, NOMBRE, CATEGORIA, DESCRIPCION, PRECIO, FOTO1, CLIENTE_USER) VALUES ('2021-09-18','XBOX SERIES S','Consolas','Te Presentamos la Xbox Series S, la consola de Xbox más pequeña y elegante de la historia. Experimenta la velocidad y el rendimiento de una consola de última generación totalmente digital a un precio asequible.',299.95, 'https://media.game.es/COVERV2/3D_L/182/182900.png', 'antonia44');
INSERT INTO PRODUCTO (PUBLICATION_DATE, NOMBRE, CATEGORIA, DESCRIPCION, PRECIO, FOTO1, CLIENTE_USER) VALUES ('2021-02-08','PLAYSTATION 4','Consolas','La consola más vendida del mundo, ahora con un nuevo aspecto y también con asombrosos gráficos HDR. Disfruta de colores increíblemente vivos y brillantes.',184.95, 'https://media.game.es/COVERV2/3D_L/102/102114.png', 'GuillermoTel');
INSERT INTO PRODUCTO (PUBLICATION_DATE, NOMBRE, CATEGORIA, DESCRIPCION, PRECIO, FOTO1, CLIENTE_USER) VALUES ('2021-01-12','FIFA 22 - PC','Juegos','Powered by Football™, EA SPORTS™ FIFA 22 acerca aún más el juego a la realidad gracias a mejoras significativas en la jugabilidad y una nueva temporada de novedades en todos los modos.',54.90, 'https://www.vsgamers.es/thumbnails/product_gallery_medium/uploads/products/EA/fifa%2022%20pc/galeria/juego-ea-sports-fifa-22-pc-galeria-1.jpg', 'AmanteDeLosPozos');
INSERT INTO PRODUCTO (PUBLICATION_DATE, NOMBRE, CATEGORIA, DESCRIPCION, PRECIO, FOTO1, CLIENTE_USER) VALUES ('2021-06-10','SUPER MARIO ODYSSEY','Juegos','Acompaña a Mario en una enorme aventura en 3D por todo el planeta usando sus nuevas habilidades para recoger lunas que servirán de combustible a tu aeronave, la Odyssey.',49.90, 'https://www.vsgamers.es/thumbnails/product_gallery_medium/uploads/products/nintendo/juegos/juego-nintendo-switch-super-mario-odyssey/galeria/juego-nintendo-switch-super-mario-odyssey-galeria.jpg', 'meloguiso');
INSERT INTO PRODUCTO (PUBLICATION_DATE, NOMBRE, CATEGORIA, DESCRIPCION, PRECIO, FOTO1, CLIENTE_USER) VALUES ('2021-11-08','SUPER SMASH BROS. ULTIMATE','Juegos','Luchadores y mundos de juego míticos colisionan en el enfrentamiento definitivo: ¡una nueva entrada de la serie Super Smash Bros. para Nintendo Switch!',58.90, 'https://www.vsgamers.es/thumbnails/product_gallery_medium/uploads/products/nintendo/juegos/juego-nintendo-switch-super-smash-bros-ultimate/galeria/juego-nintendo-switch-super-smash-bros-ultimate-galeria.jpg', 'GuillermoTel');
INSERT INTO PRODUCTO (PUBLICATION_DATE, NOMBRE, CATEGORIA, DESCRIPCION, PRECIO, FOTO1, CLIENTE_USER) VALUES ('2021-10-02','MARIO + RABBIDS KINGDOM BATTLE','Juegos','Esta es la historia de un encuentro inesperado entre Mario y los irreverentes Rabbids.',24.90, 'https://www.vsgamers.es/thumbnails/product_gallery_medium/uploads/products/nintendo/juegos/juego-mario-rabbids-kingdom-battle-nintendo-switch/galeria/juego-mario-rabbids-kingdom-battle-nintendo-switch-galeria.jpg', 'meloguiso');