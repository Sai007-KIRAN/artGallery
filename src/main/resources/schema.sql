-- Create Artist Table
CREATE TABLE IF NOT EXISTS artist (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    genre varchar(255)
);

-- Create Art Table
CREATE TABLE IF NOT EXISTS art (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title varchar(255),
    theme varchar(255),
    artistId INTEGER,
    FOREIGN KEY (artistId) REFERENCES artist(id)
);

-- Create Gallery Table
CREATE TABLE IF NOT EXISTS gallery (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    location varchar(255)
);

-- Create Junction Table for Artists and Galleries
CREATE TABLE IF NOT EXISTS artist_gallery (
    artistId INTEGER,
    galleryId INTEGER,
    PRIMARY KEY (artistId, galleryId),
    FOREIGN KEY (artistId) REFERENCES artist(id),
    FOREIGN KEY (galleryId) REFERENCES gallery(id)
);
