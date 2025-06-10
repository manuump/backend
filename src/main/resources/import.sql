INSERT INTO usuario (username, password, email, enabled, tipo) VALUES
('admin',  '$2a$12$QUTZthUgVf3GaXkO62PfXONas.hmWNNnk1dqIrIUlZUILDRaP/i1u', 'admin@ociojaen.com', true, 'ADMIN'),
('empresa', '$2a$12$oWJDVzdo2kcujJSzd9uXlOemUQOjxP/zKh3AXIekHbei0nJl556kG', 'empresa@ociojaen.com', true, 'EMPRESA'),
('empresa2', '$2a$10$DowJmL5ujX2Q/E1H7YZEXefgWlFSz17y6xzzD2NvJH72zQg7bZc8.', 'empresa2@ociojaen.com', true, 'EMPRESA'),
('manu', '$2a$12$g1byzY8LeZlRoZsVjb8V8OCMzYJNHAli.sa5M4NRJwqjskniJSv1K', 'manu@ociojaen.com', true, 'USUARIO'),
('usuario2', '$2a$10$DowJmL5ujX2Q/E1H7YZEXefgWlFSz17y6xzzD2NvJH72zQg7bZc8.', 'usuario2@ociojaen.com', true, 'USUARIO'); 



INSERT INTO evento (nombre, descripcion, fecha, ubicacion, organizador_id, imagen_url) VALUES
('Feria de Gastronomía', 'Descubre lo mejor de la cocina jiennense.', '2025-07-15 18:00:00', 'Plaza de la Constitución', 2, 'https://example.com/images/feria-gastro.jpg'),
('Concierto Flamenco', 'Actuación de grandes artistas locales.', '2025-08-10 21:00:00', 'Teatro Infanta Leonor', 2, 'https://example.com/images/concierto-flamenco.jpg'),
('Ruta de Senderismo', 'Recorre la Sierra de Cazorla con guía.', '2025-09-05 09:00:00', 'Parque Natural de Cazorla', 3, 'https://example.com/images/ruta-senderismo.jpg'),
('Mercado Medieval', 'Vive la Edad Media con espectáculos y comida.', '2025-07-20 11:00:00', 'Calle Maestra', 3, 'https://example.com/images/mercado-medieval.jpg'),
('Visita Nocturna a la Catedral de Jaén', 'Explora la majestuosa catedral bajo la luz de la luna con guía experto.', '2025-07-25 22:00:00', 'Catedral de Jaén', 3, 'https://www.civitatis.com/f/espana/jaen/visita-guiada-catedral-jaen-589x392.jpg'),
('Partido del Real Jaén C.F.', 'Disfruta del emocionante encuentro de liga en el estadio.', '2025-08-30 19:30:00', 'Estadio de La Victoria', 2, 'https://realjaen.com/wp-content/uploads/2022/07/ESCUDO_FONDO_RJ.jpeg'),
('Exhibición de Jaén Paraíso Interior FS', 'Vive la pasión del fútbol sala con el equipo de la ciudad.', '2025-09-15 20:00:00', 'Palacio de Deportes Olivo Arena', 3, 'https://i0.wp.com/sextoanillo.com/wp-content/uploads/2021/02/comunicado-febrero.jpg?resize=1170%2C780&ssl=1');

--password users: "test1234"