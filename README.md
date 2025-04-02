# EXAMEN_JAVA-CARVAJAL_NILSON

CREACION DE LA BASE DE DATOS

"""
CREATE DATABASE IF NOT EXISTS centro_salud;
USE centro_salud;

CREATE TABLE Especialidad (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    UNIQUE KEY (nombre)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE Paciente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    direccion VARCHAR(200),
    telefono VARCHAR(20),
    email VARCHAR(100),
    UNIQUE KEY (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE Medico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    especialidad_id INT NOT NULL,
    horario_inicio TIME NOT NULL,
    horario_fin TIME NOT NULL,
    FOREIGN KEY (especialidad_id) REFERENCES Especialidad(id) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE Cita (
    id INT AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT NOT NULL,
    medico_id INT NOT NULL,
    fecha_hora DATETIME NOT NULL,
    estado ENUM('PENDIENTE', 'CONFIRMADA', 'CANCELADA', 'COMPLETADA') NOT NULL DEFAULT 'PENDIENTE',
    FOREIGN KEY (paciente_id) REFERENCES Paciente(id) ON DELETE CASCADE,
    FOREIGN KEY (medico_id) REFERENCES Medico(id) ON DELETE CASCADE,
    UNIQUE KEY (medico_id, fecha_hora)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO Especialidad (nombre) VALUES 
('Cardiología'),
('Dermatología'),
('Pediatría'),
('Neurología'),
('Ortopedia');

INSERT INTO Paciente (nombre, apellido, fecha_nacimiento, direccion, telefono, email) VALUES 
('Juan', 'Pérez', '1985-05-15', 'Calle Falsa 123', '5551234567', 'juan.perez@email.com'),
('María', 'Gómez', '1990-08-22', 'Avenida Siempreviva 742', '5557654321', 'maria.gomez@email.com');

INSERT INTO Medico (nombre, especialidad_id, horario_inicio, horario_fin) VALUES 
('Dr. Carlos', 1, '08:00:00', '16:00:00'),
('Dra. Ana', 2, '09:00:00', '17:00:00');

INSERT INTO Cita (paciente_id, medico_id, fecha_hora, estado) VALUES 
(1, 1, '2023-12-15 10:00:00', 'PENDIENTE'),
(2, 2, '2023-12-16 11:00:00', 'CONFIRMADA'); """

