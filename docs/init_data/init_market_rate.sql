insert INTO tcoin_currency_rate(currency, refer_currency, origin, rate, update_datetime)
    VALUES
      ('USD','CNY','juhe',6.6484,now()),
      ('HKD','CNY','juhe',0.8521,now());

#行情
INSERT INTO tcoin_market(coin, refer_currency, origin, last_price, low, high, volume, update_datetime, bid, ask, mid) VALUES ('ETH','CNY','bitfinex',100,100,100,'10000',NOW(),100,100,100);