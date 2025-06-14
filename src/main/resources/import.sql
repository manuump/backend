INSERT INTO usuario (username, password, email, enabled, tipo) VALUES
('admin',  '$2a$12$QUTZthUgVf3GaXkO62PfXONas.hmWNNnk1dqIrIUlZUILDRaP/i1u', 'admin@ociojaen.com', true, 'ADMIN'),
('flamenco', '$2a$12$.2cZIsm5/8.v.l/ehfDkmOZ6podA/2gCF3jSpuM7V4HM96UBeDre.', 'cultura@ociojaen.com', true, 'EMPRESA'),
('realjaen', '$2a$12$.2cZIsm5/8.v.l/ehfDkmOZ6podA/2gCF3jSpuM7V4HM96UBeDre.', 'realjaen@ociojaen.com', true, 'EMPRESA'),
('jaenfs', '$2a$12$.2cZIsm5/8.v.l/ehfDkmOZ6podA/2gCF3jSpuM7V4HM96UBeDre.', 'jaenfs@ociojaen.com', true, 'EMPRESA'),
('turismo', '$2a$12$.2cZIsm5/8.v.l/ehfDkmOZ6podA/2gCF3jSpuM7V4HM96UBeDre.', 'turismo@ociojaen.com', true, 'EMPRESA'),
('kharma', '$2a$12$.2cZIsm5/8.v.l/ehfDkmOZ6podA/2gCF3jSpuM7V4HM96UBeDre.', 'kharma@ociojaen.com', true, 'EMPRESA'),
('jaenplaza', '$2a$12$.2cZIsm5/8.v.l/ehfDkmOZ6podA/2gCF3jSpuM7V4HM96UBeDre.', 'jaenplaza@ociojaen.com', true, 'EMPRESA'),
('IFEJA', '$2a$12$.2cZIsm5/8.v.l/ehfDkmOZ6podA/2gCF3jSpuM7V4HM96UBeDre.', 'ifeja@ociojaen.com', true, 'EMPRESA'),
('deporte', '$2a$12$.2cZIsm5/8.v.l/ehfDkmOZ6podA/2gCF3jSpuM7V4HM96UBeDre.', 'deporte@ociojaen.com', true, 'EMPRESA'),
('manu', '$2a$12$g1byzY8LeZlRoZsVjb8V8OCMzYJNHAli.sa5M4NRJwqjskniJSv1K', 'manu@ociojaen.com', true, 'USUARIO'),
('pepe', '$2a$12$g1byzY8LeZlRoZsVjb8V8OCMzYJNHAli.sa5M4NRJwqjskniJSv1K', 'pepe@ociojaen.com', true, 'USUARIO'),
('antonio', '$2a$12$g1byzY8LeZlRoZsVjb8V8OCMzYJNHAli.sa5M4NRJwqjskniJSv1K', 'antonio@ociojaen.com', true, 'USUARIO'),
('cristina', '$2a$12$g1byzY8LeZlRoZsVjb8V8OCMzYJNHAli.sa5M4NRJwqjskniJSv1K', 'cristina@ociojaen.com', true, 'USUARIO'),
('lucia', '$2a$12$g1byzY8LeZlRoZsVjb8V8OCMzYJNHAli.sa5M4NRJwqjskniJSv1K', 'lucia@ociojaen.com', true, 'USUARIO'),
('maria', '$2a$12$g1byzY8LeZlRoZsVjb8V8OCMzYJNHAli.sa5M4NRJwqjskniJSv1K', 'maria@ociojaen.com', true, 'USUARIO'),
('lourdes', '$2a$12$g1byzY8LeZlRoZsVjb8V8OCMzYJNHAli.sa5M4NRJwqjskniJSv1K', 'lourdes@ociojaen.com', true, 'USUARIO'),
('jose', '$2a$12$g1byzY8LeZlRoZsVjb8V8OCMzYJNHAli.sa5M4NRJwqjskniJSv1K', 'jose@ociojaen.com', true, 'USUARIO');



INSERT INTO evento (nombre, descripcion, fecha, ubicacion, organizador_id, imagen_url) VALUES
('VivoFlow', 'Festival de musica comercial en Jaén.', '2025-07-15 18:00:00', 'Estadio de La Victoria', 3, 'https://vivoflowfest.com/wp-content/uploads/2025/02/Llega-Vivo-Flow-Fest-Jaen.png'),
('Concierto Flamenco', 'Actuación de grandes artistas locales.', '2025-08-10 21:00:00', 'Teatro Infanta Leonor', 2, 'https://www.juntadeandalucia.es/cultura/agendaculturaldeandalucia/sites/default/files/styles/header_activity_ext_2xl/public/2024-10/flamenco%20jaen.jpg.webp?itok=MmIYmodL'),
('Catedral de Jaén', 'Explora la majestuosa catedral bajo la luz de la luna con guía experto.', '2025-07-25 22:00:00', 'Catedral de Jaén', 5, 'https://www.civitatis.com/f/espana/jaen/visita-guiada-catedral-jaen-589x392.jpg'),
('Partido del Real Jaén C.F.', 'Disfruta del emocionante encuentro de liga en el estadio.', '2025-08-30 19:30:00', 'Estadio de La Victoria', 3, 'https://realjaen.com/wp-content/uploads/2022/07/ESCUDO_FONDO_RJ.jpeg'),
('Exhibición de Jaén Paraíso Interior FS', 'Vive la pasión del fútbol sala con el equipo de la ciudad.', '2025-09-15 20:00:00', 'Palacio de Deportes Olivo Arena', 4, 'https://i0.wp.com/sextoanillo.com/wp-content/uploads/2021/02/comunicado-febrero.jpg?resize=1170%2C780&ssl=1'),
('Castillo Santa Catalina', 'Descubre la historia y el misterio que envuelven el imponente Castillo de Santa Catalina.', '2025-07-30 18:00:00', 'Castillo Santa Catalina', 5, 'https://spainheritageimg.s3.eu-west-3.amazonaws.com/files/imagenes/visitas_castillos/176/2950-batch_img_9591.webp'),
('Torneo Fútbol Base Jaén', 'Las futuras promesas del fútbol andaluz se dan cita en este torneo de categoría base que reúne a clubes de toda la provincia. Un evento deportivo familiar, lleno de compañerismo y pasión por el deporte.', '2025-09-07 10:00:00', 'Campo Las Fuentezuelas', 3, 'https://i0.wp.com/elfocodejaen.com/wp-content/uploads/2024/04/Presentacion-Torneo-Internacional-Ciudad-de-Jaen-%E2%80%93-Jaen-Cup.png?resize=678%2C381&ssl=1'),
('Kharma Summer Night', 'La fiesta más esperada del verano llega a Kharma. Disfruta de la mejor música comercial y electrónica con DJs invitados, espectáculo de luces, zonas VIP y promociones especiales en copas.', '2025-07-27 23:00:00', 'Sala Kharma', 6, 'https://s3.eu-central-1.amazonaws.com/images.jacksonlive.es/upload/spots/high/6621585608685.jpg'),
('CC Jaén Plaza','Disfruta de una jornada especial en Jaén Plaza con música en vivo, descuentos exclusivos en tiendas, sorteos y actividades para toda la familia.', '2025-07-20 17:00:00', 'Centro Comercial Jaén Plaza', 7,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTaL1JgMFmAC8P5USyaQB7WOokSuYrG7bZzw&s'),
('Expoliva 2025', 'La mayor feria mundial del aceite de oliva regresa a Jaén. Descubre las últimas innovaciones del sector oleícola. Un evento clave para profesionales y amantes del AOVE.', '2025-09-10 10:00:00', 'IFEJA', 8, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQa6LmDrt6cCK6IpgQAF4p2o2NWZ4Jt__vsgQ&s'),
('Carrera Popular San Antón', 'Participa en la tradicional Carrera de San Antón, una competición popular que recorre las calles más emblemáticas de Jaén en honor al patrón de los animales.', '2025-01-17 10:00:00', 'Recorrido urbano por Jaén', 9, 'https://i.ytimg.com/vi/X3OzaDPqi5M/maxresdefault.jpg'),
('Visita a los Baños Árabes de Jaén', 'Sumérgete en la historia con una visita guiada por los antiguos Baños Árabes, uno de los monumentos más emblemáticos y mejor conservados de la ciudad.', '2025-07-22 18:30:00', 'Baños Árabes de Jaén', 5, 'https://www.orgullososdejaen.es/wp-content/uploads/2017/11/banos-ok-1200x580.jpg'),
('Hacken Jaén 2025', 'Congreso internacional de ciberseguridad donde expertos, profesionales y entusiastas se reúnen para compartir conocimientos, talleres y ponencias sobre seguridad digital.', '2025-11-05 09:00:00', 'IFEJA', 8, 'https://i.ytimg.com/vi/5ZOro6_GfNE/hqdefault.jpg'),
('Carrera de la Salud', 'Únete a la Carrera de la Salud, un evento deportivo que promueve hábitos saludables y la vida activa en la ciudad de Jaén. Recorrido accesible para todas las edades y niveles.', '2025-05-12 10:00:00', 'Parque de la Concordia', 9, 'https://www.cruzandolameta.es/media/competiciones/WEB_FRQJOXJ.jpg');
