-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('ola@student.merito.pl',   'Ola',   'USER',    current_timestamp),
    ('kuba@student.merito.pl',  'Kuba',  'USER',    current_timestamp),
    ('firma@example.com',       'Firma', 'PARTNER', current_timestamp),
    ('admin@example.com',       'Admin', 'ADMIN',   current_timestamp);

insert into user_account (email, display_name, role, created_at) values
    ('s964974@student.wroclaw.merito.pl', 'Mateusz Królik', 'USER', current_timestamp),
    ('s180865@student.wroclaw.merito.pl',   'Bartłomiej Adamkiewicz',   'USER', current_timestamp),
    ('s986274@student.wroclaw.merito.pl',     'Lilliana Bassa',     'USER', current_timestamp);
