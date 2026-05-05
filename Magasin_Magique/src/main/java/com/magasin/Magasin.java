package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            items[i] = decreaseSellIn(items[i]);
            switch (items[i].name) {
                case "Comté":
                    upgradeQualityComte(items[i]);
                    break;
                case "Pass VIP Concert":
                    items[i] = upgradeQualityPassVIPConcert(items[i]);
                    break;
                case "Kryptonite":
                    // il ne se passe rien
                    break;
                case "Pouvoirs magiques":
                    items[i] = upgradeQualityPouvoirsMagiques(items[i]);
                    break;
                default:
                    upgradeQualityOthers(items[i]);
                    break;
            }
        }
    }


    public Item upgradeQualityOthers (Item item) {
        if (item.sellIn>0) {
            item = decreaseQuality(item, 1);
        } else {
            item = decreaseQuality(item, 2);
        }
        return item;
    }

    public Item upgradeQualityComte (Item item) {
        if (item.sellIn>=0) {
            item = increaseQuality(item, 1);
        }else {
            item = increaseQuality(item, 2);
        }
        return item;
    }

    public Item upgradeQualityPouvoirsMagiques (Item item) {
       // if (item.sellIn>0) {
            item = decreaseQuality(item, 2);
//        } else {
//            item = decreaseQuality(item, 4);
//        }
        return item;
    }

    public Item upgradeQualityPassVIPConcert (Item item){
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn < 5){
            increaseQuality(item, 3);
        } else if ( item.sellIn < 10){
            increaseQuality(item, 2);
        } else {
            increaseQuality(item, 1);
        }
        return item;
    }

    public Item increaseQuality (Item item, int quantity) {
        if ((item.quality + quantity) >=50) {
            item.quality = 50;
        } else {
            item.quality += quantity;
        }
        return item;
    }

    public Item decreaseQuality (Item item, int quantity) {
        if ((item.quality - quantity) >= 0) {
            item.quality -= quantity;
        } else {
            item.quality = 0;
        }
        return item;
    }

    public Item decreaseSellIn (Item item) {
        if (!item.name.equals("Kryptonite")) {
            item.sellIn -=1;
        }
        return item;
    }
}
