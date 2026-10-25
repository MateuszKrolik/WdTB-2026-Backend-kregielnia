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

insert into bowling_lane (lane_number, max_players, hourly_price, active) values
    (1, 6, 40.00, true),
    (2, 6, 40.00, true),
    (3, 8, 60.00, false);

insert into booking (start_at, duration_hours, players, status, total_price) values
    ('2026-11-14 18:00:00', 2, 4, 'CONFIRMED', 80.00),
    ('2026-11-14 20:00:00', 1, 6, 'PENDING',   40.00),
    ('2026-11-15 17:00:00', 2, 8, 'CANCELLED', 120.00);

insert into customer (full_name, email, phone, registered_on, street, city, postal_code) values
    ('Marek Zieliński',  'marek.zielinski@example.com', '600100200', '2026-10-01', 'Ruska 12',      'Wrocław', '50-079'),
    ('Katarzyna Lis',    'katarzyna.lis@example.com',   null,        '2026-10-12', null,            null,      null),
    ('Tomasz Wójcik',    'tomasz.wojcik@example.com',   '600500600', '2026-10-20', 'Świdnicka 3/4', 'Wrocław', '50-066');
