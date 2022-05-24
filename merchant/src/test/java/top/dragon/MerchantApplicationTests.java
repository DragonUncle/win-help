package top.dragon;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.dragon.entity.SweetGoodsShop;
import top.dragon.service.SweetGoodsShopPictureService;
import top.dragon.service.SweetGoodsShopService;

import javax.annotation.Resource;

@SpringBootTest
class MerchantApplicationTests {

    @Resource
    private SweetGoodsShopService goodsShopService;

    @Resource
    private SweetGoodsShopPictureService goodsShopPictureService;
    @Test
    void contextLoads() {
        SweetGoodsShop testShop = new SweetGoodsShop().setShopName("testShop");
        goodsShopService.save(testShop);
        System.out.println(testShop);

    }
    @Test
    void contextLoads1() {
        SweetGoodsShop testShop = new SweetGoodsShop().setShopName("testShop");
        goodsShopService.save(testShop);
        System.out.println(testShop);

    }

}
