SELECT * FROM public.fatture
ORDER BY numerofattura ASC select * from public.clienti where nome='Mario';

select nome,cognome, count(*) from public.clienti 
WHERE Extract(year from annodinascita) = 1982
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

select extract(year from datafattura) anno, count(*) numero_di_fatture, sum(importo) importo_totale
from public.fatture
where iva = 20
group by anno;


select extract(year from datafattura) anno, count(*) numero_fatture
from public.fatture
where tipologia='A'
group by anno
having count(*)>2;

select c.regione_residenza,sum(f.importo)
from public.fatture f inner join public.clienti  c
on f.idcliente= c.numerocliente
group by c.regione_residenza ;


SELECT COUNT(DISTINCT c.numerocliente) 
FROM public.clienti c 
INNER JOIN public.fatture f ON c.numerocliente = f.idcliente 
WHERE f.importo > 50 AND EXTRACT(year FROM c.annodinascita) = 1980;


