package interviews.nexthink;

import lombok.Value;
import org.checkerframework.checker.nullness.Opt;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoldProductsAggregator {

    public static void main(String[] args) {
        SoldProduct soldProduct1 = new SoldProduct("tedy", new BigDecimal(10.0), "INR");
        SoldProduct soldProduct2 = new SoldProduct("truck", new BigDecimal(20.0), "INR");
        SoldProduct soldProduct3 = new SoldProduct("blocks", new BigDecimal(30.0), "INR");
        List<SoldProduct> l = new ArrayList<>();
        l.add(soldProduct1);
        l.add(soldProduct2);
        l.add(soldProduct3);

        SoldProductsAggregator soldProductsAggregator = new SoldProductsAggregator(new ExchangeService());
        soldProductsAggregator.aggregate(l.stream());
    }

    private final EURExchangeService exchangeService;

    SoldProductsAggregator(EURExchangeService EURExchangeService) {
        this.exchangeService = EURExchangeService;
    }

    SoldProductsAggregate aggregate(Stream<SoldProduct> products) {

        List<SimpleSoldProduct> list = products.filter(x -> exchangeService.rate(x.getCurrency()).isPresent()).map(x -> {
            SimpleSoldProduct s = new SimpleSoldProduct(x.getName(), x.getPrice().multiply(exchangeService.rate(x.getCurrency()).get()));
            return s;
        }).collect(Collectors.toList());

        BigDecimal total = list.stream().map(simpleSoldProduct -> {
            return simpleSoldProduct.getPrice();
        }).reduce((price1, price2) -> {
            return ((BigDecimal) price1).add(price2);
        }).get();

        System.out.println(new SoldProductsAggregate(list, total));
        return new SoldProductsAggregate(list, total);

    }

}

@Value
class SimpleSoldProduct {
    String name;
    BigDecimal price;
}

@Value
class SoldProduct {
    String name;
    BigDecimal price;
    String currency;
}

@Value
class SoldProductsAggregate {
    List<SimpleSoldProduct> products;
    BigDecimal total;
}

interface EURExchangeService {
    Optional<BigDecimal> rate(String currency);
}


class ExchangeService implements EURExchangeService {
    public Optional<BigDecimal> rate(String currency) {
        return Optional.of(new BigDecimal(70));
    }
}