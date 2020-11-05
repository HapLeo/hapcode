package top.hapleow.hapcodeweb.service;

import top.hapleow.hapcodeweb.dto.CodingDto;

/**
 * 生成器服务类
 *
 * @author wuyulin
 * @date 2020/9/16
 */
public interface IHapCodeService {


    void coding(CodingDto codingDto);

    void codingAll(CodingDto codingDto);

}
