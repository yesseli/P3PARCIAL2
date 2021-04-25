Insert into clientes(id, Nombre, Edad, Sexo, Pais, fecha) values (1,'maria' , 25, 'femenino', 'mexico', {d '2021-01-21'});
Insert into clientes(id, Nombre, Edad, Sexo, Pais, fecha) values (2,'juan' , 30, 'masculino', 'guatemala', {d '2020-04-16'});


Insert into tarifa (id, tarifa, Descripcion, Monto, fecha) values (1,'PLAN CHIDO' ,'Permite ver en hasta 6 pantallas a la vez, ultra HD', 150, {d '2020-01-21'});
Insert into tarifa (id, tarifa, Descripcion, Monto, fecha) values (2,'PLAN ESTANDAR' ,'Permite ver en 3 pantallas a la vez', 100, {d '2020-02-12'});

Insert into pagos (id, fecha, monto, Tarjeta, estado) values (1, '2020-04-23', 150, 123456789,'PAGO REALIZADO');
Insert into pagos (id, fecha, monto, Tarjeta, estado) values (2, '2020-04-24', 100, 987654321,'PAGO RECHAZADO');