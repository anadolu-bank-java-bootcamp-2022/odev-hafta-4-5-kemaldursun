CREATE TABLE public.product (
    id bigint NOT NULL,
    "name" varchar NOT NULL,
    description varchar NOT NULL,
    CONSTRAINT product_pkey PRIMARY KEY (id)
);

CREATE TABLE public.owner (
    id bigint NOT NULL,
    full_name varchar NOT NULL,
    email varchar NOT NULL,
    CONSTRAINT owner_pkey PRIMARY KEY (id)
);

CREATE TABLE public.order (
    id bigint NOT NULL,
    status varchar NOT NULL,
    requester_id bigint NOT NULL,
    bidder_id bigint NOT NULL,
    requester_address varchar NOT NULL,
    bidder_address varchar NOT NULL,
    CONSTRAINT order_pkey PRIMARY KEY (id)
);

CREATE TABLE public.order_detail (
    id bigint NOT NULL,
    status varchar NOT NULL,                    -- ACCEPTED, ON_THE_WAY, SHIPPED
    type varchar NOT NULL,                      -- REQUEST, BID
    order_id bigint NOT NULL,
    product_id bigint NOT NULL,
    amount float NOT NULL,
    amount_type varchar NOT NULL,
    CONSTRAINT order_detail_pkey PRIMARY KEY (id)
);

INSERT INTO public.product(id, name, description) values(1, 'Jedi Figure Set', 'May the 4th be with you!');
INSERT INTO public.product(id, name, description) values(2, 'Warhammer Figure Set', 'In the grim darkness of the far future, there is only war.');

INSERT INTO public.owner(id, full_name, email) values (1, 'Herione Ranger', 'herione.ranger@yopmail.com');
INSERT INTO public.owner(id, full_name, email) values (2, 'Barry Toddler', 'barry.toddler@yopmail.com');
INSERT INTO public.owner(id, full_name, email) values (3, 'Albis Fumbledoor', 'albus.fumbledoor@yopmail.com');

INSERT INTO public.order(id, status, requester_id, bidder_id, requester_address, bidder_address)
VALUES(1, 'IN_PROGRESS', 2, 1, 'Baker Street 221B', 'Red Crown Street 21-A');

INSERT INTO public.order_detail(id, status, type, order_id, product_id, amount, amount_type)
VALUES(1, 'ON_THE_WAY', 'REQUEST', 1, 2, 1.0, 'set(s)'), (2, 'SHIPPED', 'BID', 1, 1, 1.0, 'set(s)');
