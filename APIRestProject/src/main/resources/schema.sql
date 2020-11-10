
CREATE TABLE IF NOT EXISTS DEPARTAMENTO(
                                           ID LONG PRIMARY KEY NOT NULL ,
                                           NOMBREDEPARTAMENTO VARCHAR(200) NOT NULL

);
CREATE TABLE IF NOT EXISTS EMPLEADO(
                                       IDEMPLEADO LONG PRIMARY KEY NOT NULL ,
                                       NOMBRE VARCHAR(200) NOT NULL ,
                                       CARGO VARCHAR(200) NOT NULL,
                                       SALARIO DOUBLE NOT NULL,
                                       tiempoCompleto BOOLEAN NOT NULL,
                                       departamentoAsingnado LONG,
                                       FOREIGN KEY (departamentoAsingnado) REFERENCES DEPARTAMENTO(ID)
);

