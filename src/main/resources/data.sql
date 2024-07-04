-- Insert data into artist table
INSERT INTO artist (id, name, genre) VALUES (1, 'Leonardo da Vinci', 'Renaissance');
INSERT INTO artist (id, name, genre) VALUES (2, 'Vincent van Gogh', 'Post-Impressionism');
INSERT INTO artist (id, name, genre) VALUES (3, 'Pablo Picass', 'Cubism');
INSERT INTO artist (id, name, genre) VALUES (4, 'Edward Hopper', 'American Modernism');

-- Insert data into art table
INSERT INTO art (id, title, theme, artistId) VALUES (1, 'The Flight Study', 'Studies of Bird Wings', 1);
INSERT INTO art (id, title, theme, artistId) VALUES (2, 'Mona Lisa 2.0', 'Renaissance Portrait', 1);
INSERT INTO art (id, title, theme, artistId) VALUES (3, 'Starry Countryside', 'Night Landscape', 2);
INSERT INTO art (id, title, theme, artistId) VALUES (4, 'Sunflower Impressions', 'Floral', 2);
INSERT INTO art (id, title, theme, artistId) VALUES (5, 'Cubist Self-Portrait', 'Abstract Portrait', 3);
INSERT INTO art (id, title, theme, artistId) VALUES (6, 'Barcelona Abstracted', 'City Landscape', 3);
INSERT INTO art (id, title, theme, artistId) VALUES (7, 'Downtown Solitude', 'Urban Scene', 4);
INSERT INTO art (id, title, theme, artistId) VALUES (8, 'Night Cafe Redux', 'Modernist Interior', 4);

-- Insert data into gallery table
INSERT INTO gallery (id, name, location) VALUES (1, 'Louvre Museum', 'Paris');
INSERT INTO gallery (id, name, location) VALUES (2, 'Van Gogh Museum', 'Amsterdam');
INSERT INTO gallery (id, name, location) VALUES (3, 'Museo Picasso', 'Barcelona');
INSERT INTO gallery (id, name, location) VALUES (4, 'Whitney Museum of American Art', 'New York');

-- Insert data into artist_gallery table
INSERT INTO artist_gallery (artistId, galleryId) VALUES (1, 1);
INSERT INTO artist_gallery (artistId, galleryId) VALUES (1, 2);
INSERT INTO artist_gallery (artistId, galleryId) VALUES (2, 2);
INSERT INTO artist_gallery (artistId, galleryId) VALUES (3, 3);
INSERT INTO artist_gallery (artistId, galleryId) VALUES (3, 4);
INSERT INTO artist_gallery (artistId, galleryId) VALUES (4, 4);
