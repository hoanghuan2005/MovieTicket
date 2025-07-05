CREATE TABLE Roles (
    role_id INT PRIMARY KEY,
    role_name NVARCHAR(50) -- Admin, Staff, Customer
);

CREATE TABLE Users (
    user_id INT IDENTITY PRIMARY KEY,
    name NVARCHAR(100),
    email NVARCHAR(100) UNIQUE,
    password NVARCHAR(255),
    phone NVARCHAR(15),
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES Roles(role_id)
);

CREATE TABLE Genres (
    genre_id INT IDENTITY PRIMARY KEY,
    name NVARCHAR(50)
);

CREATE TABLE Movies (
    movie_id INT IDENTITY PRIMARY KEY,
    title NVARCHAR(200),
    description NVARCHAR(MAX),
    duration INT, -- phút
    release_date DATE,
    poster_url NVARCHAR(255),
    trailer_url NVARCHAR(255),
    language NVARCHAR(50),
    rated NVARCHAR(20),
    status NVARCHAR(20) -- Coming Soon / Now Showing / Stop
);

CREATE TABLE MovieGenres (
    movie_id INT,
    genre_id INT,
    PRIMARY KEY (movie_id, genre_id),
    FOREIGN KEY (movie_id) REFERENCES Movies(movie_id),
    FOREIGN KEY (genre_id) REFERENCES Genres(genre_id)
);

CREATE TABLE Cinemas (
    cinema_id INT IDENTITY PRIMARY KEY,
    name NVARCHAR(100),
    address NVARCHAR(255),
    city NVARCHAR(100),
    phone NVARCHAR(15)
);

CREATE TABLE Rooms (
    room_id INT IDENTITY PRIMARY KEY,
    cinema_id INT,
    name NVARCHAR(50),
    capacity INT,
    FOREIGN KEY (cinema_id) REFERENCES Cinemas(cinema_id)
);

CREATE TABLE Seats (
    seat_id INT IDENTITY PRIMARY KEY,
    room_id INT,
    seat_row CHAR(1), -- A, B, C,...
    seat_number INT,
    seat_type NVARCHAR(50), -- Normal, VIP, Couple
    FOREIGN KEY (room_id) REFERENCES Rooms(room_id)
);

CREATE TABLE Showtimes (
    showtime_id INT IDENTITY PRIMARY KEY,
    movie_id INT,
    room_id INT,
    start_time DATETIME,
    price DECIMAL(10,2),
    FOREIGN KEY (movie_id) REFERENCES Movies(movie_id),
    FOREIGN KEY (room_id) REFERENCES Rooms(room_id)
);

CREATE TABLE Bookings (
    booking_id INT IDENTITY PRIMARY KEY,
    user_id INT,
    showtime_id INT,
    booking_time DATETIME DEFAULT GETDATE(),
    total_amount DECIMAL(10,2),
    status NVARCHAR(20), -- Pending, Confirmed, Cancelled
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (showtime_id) REFERENCES Showtimes(showtime_id)
);

CREATE TABLE BookingDetails (
    booking_id INT,
    seat_id INT,
    price DECIMAL(10,2),
    PRIMARY KEY (booking_id, seat_id),
    FOREIGN KEY (booking_id) REFERENCES Bookings(booking_id),
    FOREIGN KEY (seat_id) REFERENCES Seats(seat_id)
);

CREATE TABLE Payments (
    payment_id INT IDENTITY PRIMARY KEY,
    booking_id INT,
    payment_method NVARCHAR(50), -- Credit Card, Momo, etc.
    payment_time DATETIME,
    amount DECIMAL(10,2),
    status NVARCHAR(20), -- Success, Failed, Pending
    FOREIGN KEY (booking_id) REFERENCES Bookings(booking_id)
);
