insert INTO tcoin_currency_rate(currency, refer_currency, origin, rate, update_datetime)
    VALUES
      ('USD','CNY','juhe',6.6484,now()),
      ('HKD','CNY','juhe',0.8521,now());

#行情
INSERT INTO tcoin_market (coin, refer_currency, origin, last_price, bid, ask, mid, low, high, volume, update_datetime)
VALUES
('BTC', 'CNY', 'bitfinex', 51793.8918, 51774.6689, 51793.8918, 51784.2804, 48773.2388, 53293.9440, '103442.51470008', now()),
 ('ETH', 'CNY', 'bitfinex', 2173.1865, 2173.2528, 2174.1808, 2173.7168, 2128.9737, 2221.3101, '215893.8927187', now()),
  ##
  ('BTC', 'CNY', 'okex', 51793.8918, 51774.6689, 51793.8918, 51784.2804, 48773.2388, 53293.9440, '103442.51470008', now()),
  ('ETH', 'CNY', 'okex', 2173.1865, 2173.2528, 2174.1808, 2173.7168, 2128.9737, 2221.3101, '215893.8927187', now());


