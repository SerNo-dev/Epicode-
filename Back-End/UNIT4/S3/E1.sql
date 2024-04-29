select * from public.clienti where nome='Mario';

select nome,cognome, count(*) from public.clienti 
WHERE DATE_PART('year', annodinascita)::INTEGER = 1982
group by nome,cognome;

select count(*)
from public.fatture
where iva = 20;

select * from public.prodotti 
where EXTRACT(year from dataattivazione) = 2017 and incommercio is true;

select * from public.fatture fatture inner join public.clienti clienti
on fatture.idcliente = clienti.numerocliente
where fatture.importo<100;

select * from public.fatture fatture inner join public.fornitori fornitori
on fatture.numerofornitore = fornitori.numerofornitore inner join public.clienti clienti
on fatture.idcliente = clienti.numerocliente;

select extract(year from datafattura) anno, count(*) numero_di_fatture
from public.fatture
where iva = 20
group by anno;
