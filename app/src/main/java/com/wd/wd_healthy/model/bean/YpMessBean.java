package com.wd.wd_healthy.model.bean;

import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.bean</p>
 *
 * @author 赵某某
 * @date 2022/9/12
 */
public class YpMessBean {

    /**
     * result : [{"drugsCategoryId":1,"id":1,"name":" [同仁堂]牛黄解毒片(薄膜衣片) ","picture":"https://imgq.ddky.com/c/product/328654/big/z_1.jpg?t=9898&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":2,"name":" [以岭]连花清瘟胶囊 ","picture":"https://imgq.ddky.com/c/product/500186/big/z_1.jpg?t=1534842302335&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":3,"name":" [仁和]抗病毒口服液 ","picture":"https://imgq.ddky.com/c/product/509512/big/z_1.jpg?t=1489473551400&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":4,"name":" [仁和可立克]风热感冒颗粒 ","picture":"https://imgq.ddky.com/c/product/128150/big/z_1.jpg?t=1489743264412&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":5,"name":" [济川]蒲地蓝消炎口服液 ","picture":"https://imgq.ddky.com/c/product/500578/big/z_1.jpg?t=9898&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":6,"name":" [三精]双黄连口服液 ","picture":"https://imgq.ddky.com/c/product/105703/big/z_1.jpg?t=1515723013282&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":7,"name":" [吉春]炎可宁片 ","picture":"https://imgq.ddky.com/c/product/131078/big/z_1.jpg?t=1490843321491&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":8,"name":" [仁和]穿心莲胶囊 ","picture":"https://imgq.ddky.com/c/product/129741/big/z_1.jpg?t=1540435145351&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":9,"name":" [同仁堂]牛黄上清丸 ","picture":"https://imgq.ddky.com/c/product/233340/big/z_1.jpg?t=1489457500505&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":10,"name":" [仁和]清开灵颗粒 ","picture":"https://imgq.ddky.com/c/product/535232/big/z_1.jpg?t=1525854698935&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":11,"name":" [孔孟]栀子金花丸 ","picture":"https://imgq.ddky.com/c/product/106175/big/z_1.jpg?t=1541985546706&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":12,"name":" [力克舒]复方氨酚烷胺片 ","picture":"https://imgq.ddky.com/c/product/140021/big/z_1.jpg?t=1540454774760&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":13,"name":" [扬子江]蓝芩口服液 ","picture":"https://imgq.ddky.com/c/product/328384/big/z_1.jpg?t=1520584853753&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":14,"name":" [同仁堂]牛黄清胃丸 ","picture":"https://imgq.ddky.com/c/product/106905/big/z_1.jpg?t=1490766051817&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":15,"name":" [同仁堂]牛黄解毒片(薄膜衣片) ","picture":"https://imgq.ddky.com/c/product/106290/big/z_1.jpg?t=1541754009357&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":16,"name":" [天士力]穿心莲内酯滴丸 ","picture":"https://imgq.ddky.com/c/product/102657/big/z_1.jpg?t=1504573737866&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":17,"name":" [小葵花]金银花露 ","picture":"https://imgq.ddky.com/c/product/529511/big/z_1.jpg?t=1493360758764&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":18,"name":" [金笛]复方鱼腥草合剂 ","picture":"https://imgq.ddky.com/c/product/528411/big/z_1.jpg?t=9898&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":19,"name":" [辅仁]穿王消炎胶囊 ","picture":"https://imgq.ddky.com/c/product/129464/big/z_1.jpg?t=1505205927182&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":20,"name":" [立效]防风通圣丸 ","picture":"https://imgq.ddky.com/c/product/132640/big/z_1.jpg?t=1508393795018&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":21,"name":" [惠松]复方鱼腥草合剂 ","picture":"https://imgq.ddky.com/c/product/130819/big/z_1.jpg?t=1544179386983&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":22,"name":" [同仁堂]连翘败毒丸 ","picture":"https://imgq.ddky.com/c/product/231971/big/z_1.jpg?t=1490852691876&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":23,"name":" [万顺堂]养阴口香合剂 ","picture":"https://imgq.ddky.com/c/product/106849/big/z_1.jpg?t=1504691125685&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":24,"name":" [仁和可立克]感冒软胶囊 ","picture":"https://imgq.ddky.com/c/product/123722/big/z_1.jpg?t=1540458853626&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":25,"name":" [同仁堂]防风通圣丸 ","picture":"https://imgq.ddky.com/c/product/101397/big/z_1.jpg?t=1490255572349&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":26,"name":" [雷允上]六神丸(人工麝香) ","picture":"https://imgq.ddky.com/c/product/106431/big/z_1.jpg?t=1541754303877&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":27,"name":" [同仁堂]牛黄解毒丸 ","picture":"https://imgq.ddky.com/c/product/233017/big/z_1.jpg?t=1491878330789&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":28,"name":" [同仁堂]黄连上清丸 ","picture":"https://imgq.ddky.com/c/product/106895/big/z_1.jpg?t=1545903551249&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":29,"name":" [普正]清热散结胶囊 ","picture":"https://imgq.ddky.com/c/product/131200/big/z_1.jpg?t=1490693872136&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":30,"name":" [同仁堂]通宣理肺口服液 ","picture":"https://imgq.ddky.com/c/product/100338/big/z_1.jpg?t=1490234024912&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":31,"name":" [同仁堂]通宣理肺丸 ","picture":"https://imgq.ddky.com/c/product/107462/big/z_1.jpg?t=1490765205671&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":32,"name":" [紫琉璃]炎可宁片 ","picture":"https://imgq.ddky.com/c/product/122920/big/z_1.jpg?t=1532484308167&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":33,"name":" [健民]夏桑菊颗粒 ","picture":"https://imgq.ddky.com/c/product/328356/big/z_1.jpg?t=1500962641128&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":34,"name":" [芬必得]酚咖片 ","picture":"https://imgq.ddky.com/c/product/109461/big/z_1.jpg?t=1540458613769&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":35,"name":" [同仁堂]西黄清醒丸 ","picture":"https://imgq.ddky.com/c/product/106220/big/z_1.jpg?t=1508467008080&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":36,"name":" [曙光]对乙酰氨基酚片 ","picture":"https://imgq.ddky.com/c/product/104109/big/z_1.jpg?t=1542160264847&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":37,"name":" [同仁堂]通宣理肺片(薄膜衣片) ","picture":"https://imgq.ddky.com/c/product/106827/big/z_1.jpg?t=1519378579972&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":38,"name":" [济川]蒲地蓝消炎口服液 ","picture":"https://imgq.ddky.com/c/product/518612/big/z_1.jpg?t=1496821762780&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":39,"name":" [力克舒]复方银翘氨敏胶囊 ","picture":"https://imgq.ddky.com/c/product/139503/big/z_1.jpg?t=1540454649958&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":40,"name":" [散利痛]复方对乙酰氨基酚片(Ⅱ) ","picture":"https://imgq.ddky.com/c/product/328074/big/z_1.jpg?t=1542006123527&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":41,"name":" [白云山]抗病毒软胶囊 ","picture":"https://imgq.ddky.com/c/product/523848/big/z_1.jpg?t=1540434847504&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":42,"name":" [散利痛]复方对乙酰氨基酚片(Ⅱ) ","picture":"https://imgq.ddky.com/c/product/100742/big/z_1.jpg?t=1540457025899&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":43,"name":" [泰诺林]对乙酰氨基酚缓释片 ","picture":"https://imgq.ddky.com/c/product/100540/big/z_1.jpg?t=1540456751664&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":44,"name":" [巴米尔]阿司匹林泡腾片 ","picture":"https://imgq.ddky.com/c/product/100106/big/z_1.jpg?t=1542000544068&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":45,"name":" [福森]双黄连口服液 ","picture":"https://imgq.ddky.com/c/product/106771/big/z_1.jpg?t=1524534009809&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":46,"name":" [仁和]通宣理肺片 ","picture":"https://imgq.ddky.com/c/product/103416/big/z_1.jpg?t=1540462094211&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"},{"drugsCategoryId":1,"id":47,"name":" [同仁堂]西黄丸 ","picture":"https://imgq.ddky.com/c/product/106900/big/z_1.jpg?t=1511509178232&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * drugsCategoryId : 1
         * id : 1
         * name :  [同仁堂]牛黄解毒片(薄膜衣片)
         * picture : https://imgq.ddky.com/c/product/328654/big/z_1.jpg?t=9898&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100
         */

        private int drugsCategoryId;
        private int id;
        private String name;
        private String picture;

        public int getDrugsCategoryId() {
            return drugsCategoryId;
        }

        public void setDrugsCategoryId(int drugsCategoryId) {
            this.drugsCategoryId = drugsCategoryId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }
    }
}
