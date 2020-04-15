package com.xujun.test;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

/**
 * 常用帮助类
 */
public class AppHelper {
    /**
     * 导出Excel数据
     * 传递map参数
     * @param colName excel列头
     * @param  dataList 需要导出的列表
     */
    public static byte[] exportExcel(String[] colName, List<Map<String, Object>> dataList) {
        // 第1步，创建一个HSSFWorkbook，对应一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        try {
            // 第2步，在workbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet sheet = workbook.createSheet();
            // 第3步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
            HSSFRow headRow = sheet.createRow(0);
            // 第4步，创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle style = getColumnTopStyle(workbook);
            //循环创建标题并赋值
            HSSFCell cell = null;
            for (int i = 0; i < colName.length; i++) {
                cell = headRow.createCell(i);
                cell.setCellValue(colName[i]);
                cell.setCellStyle(style);
                sheet.setColumnWidth(i, 6 * 850);
            }
            sheet.setColumnWidth(6, 6 * 3600);
            //第5步，创建内容行并赋值
            HSSFRow contentRow = null;
            for (int i = 0; i < dataList.size(); i++) {
                contentRow = sheet.createRow(i + 1);
                Map<String, Object> nowMap = dataList.get(i);
                //遍历map中的值
                int cellIndex = 0;
                for (Object value : nowMap.values()) {
                    if (value != null) {
                        contentRow.createCell(cellIndex).setCellValue(value.toString());
                    } else {
                        contentRow.createCell(cellIndex).setCellValue("");
                    }
                    cellIndex++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return downloadExcelDocument(workbook);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 列头单元格样式
     */
    private static HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 11);
        //字体加粗
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        return style;
    }

    /**
     * 浏览器下载Excel
     */
    private static byte[] downloadExcelDocument(HSSFWorkbook workbook) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        baos.flush();
        baos.close();
        byte[] bytes = baos.toByteArray();
        return bytes;
    }
}
