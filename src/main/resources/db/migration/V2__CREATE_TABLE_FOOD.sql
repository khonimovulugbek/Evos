CREATE TABLE IF NOT EXISTS food
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name     VARCHAR(255),
    title_uz VARCHAR(255),
    title_ru VARCHAR(255),
    cost     BIGINT,
    img_uz   VARCHAR(255),
    img_ru   VARCHAR(255),
    CONSTRAINT pk_food PRIMARY KEY (id)
);

ALTER TABLE food
    ADD CONSTRAINT uc_food_name UNIQUE (name);


insert into food(name, title_uz, title_ru, cost, img_uz, img_ru)
VALUES ('SET',
        '',
        '',
        0,
        'https://drive.google.com/uc?id=1KLfAOwRLj98GiWNkefHes2mCalqNn72_&export=download',
        'https://drive.google.com/uc?id=1KLfAOwRLj98GiWNkefHes2mCalqNn72_&export=download');

insert into food(name, title_uz, title_ru, cost, img_uz, img_ru)
VALUES ('COMBO+',
        'Yeng yaxshi taklif! Issiq qarsildoq qovurilgan kartoshka va bir stakan Pepsi',
        'Самое выгодное предложение! Горячий хрустящий картофель фри и стакан Pepsi',
        16000,
        'https://drive.google.com/uc?id=1AHQ5QAwNIU9j6nR_u5otB1fZA2VTWM1M&export=download',
        'https://drive.google.com/uc?id=1AHQ5QAwNIU9j6nR_u5otB1fZA2VTWM1M&export=download');

insert into food(name, title_uz, title_ru, cost, img_uz, img_ru)
VALUES ('BABY_COMBO',
        '',
        'Выгодное предложение для маленьких гостей за 15 000 сум',
        16000,
        'https://drive.google.com/uc?id=1xHOgJLtYH3UlCaSrCtx7anxfkta-SJfQ&export=download',
        'https://drive.google.com/uc?id=1xHOgJLtYH3UlCaSrCtx7anxfkta-SJfQ&export=download');

insert into food(name, title_uz, title_ru, cost, img_uz, img_ru)
VALUES ('LAVASH',
        '',
        '',
        0,
        'https://drive.google.com/uc?id=1YDDaYQgL6jp-yH9uJm6YvgRRCfdNZ07W&export=download',
        'https://drive.google.com/uc?id=1DoiF6GNh0SI6orcQoIU3Dj1lawzVpk20&export=download');

insert into food(name, title_uz, title_ru, cost, img_uz, img_ru)
VALUES ('PEPPER_CHICKEN_LAVASH',
        'Yangi bodring va pomidorlar, qarsildoq chipslar bilan lavashga oʼralgan qovurilgan tovuq filesi, bizning taʼmi oʼtkir maxsus qayla bilan',
        'Жареное куриное филе в лаваше со свежими огурцами и помидорами, хрустящими чипсами и  фирменным острым соусом',
        23000,
        'https://drive.google.com/uc?id=1ZhfYUU0YhdwlLe2ZQP1n115d_zaIWq4Z&export=download',
        'https://drive.google.com/uc?id=1ZhfYUU0YhdwlLe2ZQP1n115d_zaIWq4Z&export=download');

insert into food(name, title_uz, title_ru, cost, img_uz, img_ru)
VALUES ('PEPPER_BEEF_LAVASH',
        'Qarsildoq chipslar, yangi bodring va pomidorlar bilan lavashga oʼralgan yumshoq mol goʼshti, bizning taʼmi oʼtkir qayla bilan',
        'Сочная говядина завернута в лаваш с хрустящими чипсами, свежими огурцами и помидорами, с фирменным острым соусом',
        25000,
        'https://drive.google.com/uc?id=1NOAMddxYG26RmgdyzqtF3fw-Ji5SB92g&export=download',
        'https://drive.google.com/uc?id=1NOAMddxYG26RmgdyzqtF3fw-Ji5SB92g&export=download');

insert into food(name, title_uz, title_ru, cost, img_uz, img_ru)
VALUES ('',
        '',
        '',
        28000,
        'https://drive.google.com/uc?id=1ddBlCWAf4UJ4j2wPutCQ2781whcbDCIt&export=download',
        'https://drive.google.com/uc?id=1ddBlCWAf4UJ4j2wPutCQ2781whcbDCIt&export=download');