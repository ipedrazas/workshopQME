# Define here the models for your scraped items
#
# See documentation in:
# http://doc.scrapy.org/topics/items.html

from scrapy.item import Item, Field

class PantoneItem(Item):
    # define the fields for your item here like:
    code = Field()
    hex_code = Field()
    name = Field()
