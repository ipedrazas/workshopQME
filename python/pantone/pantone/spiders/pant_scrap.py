from scrapy.spider import BaseSpider
from scrapy.http import Request
from scrapy.http import FormRequest
from scrapy.selector import HtmlXPathSelector
from scrapy import log
from pantone.items import PantoneItem
from unicodedata import normalize
import json

class PantSpider(BaseSpider):
    name = "pantone"
    allowed_domains = ["dmoz.org"]
    start_urls = [
        "http://www.cal-print.com/InkColorChart.htm"
    ]


    def __init__(self, name=None, **kwargs):
        super(PantSpider, self).__init__(name, **kwargs)
        self.items_buffer = {}


    def parse(self, response):
        try:
            hxs = HtmlXPathSelector(response)
            rows = hxs.select('//div[@align="center"]/center/table/tbody')
            print rows

            colors = []
            i = 0
            for row in rows:
                pi = PantoneItem()
                pi['hex_code'] = row.select('tr[2]/td/@bgcolor').extract()
                pi['name'] =  self.parse_name(row.select('tr[1]/td/font/text()').extract())
                # yield req
                colors.append(pi)
            return colors

        except Exception as e:
            # Something went wrong parsing this page. Log URL so we can determine which one.
            self.log("Parsing failed for URL '{:s}'".format(response.request.url), level=log.ERROR)
            raise # Re-raise exception


    def parse_name(self, name):
        return self.flatten(''.join(name))

    def flatten(self, name):
        return ' '.join(name.split())
