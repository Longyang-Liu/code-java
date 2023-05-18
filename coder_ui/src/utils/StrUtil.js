

/**
 * @Description: 正则表达式去除字符串内的值得数据
 * @param text 文本内容
 * @param symbol 正则内容， 例：/[\r\n]/g
 * @return:
 * @Author: Liu
 * @Date: 2023/5/18 12:06
*/
export function textTrim(text, symbol){
  return text.trim().replace(symbol, '');
}