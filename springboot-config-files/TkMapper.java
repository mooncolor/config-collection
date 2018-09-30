package com.cms.kernel.mymapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.base.update.UpdateByPrimaryKeySelectiveMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

public interface TkMapper<T> extends Mapper<T>,InsertListMapper<T>,UpdateByPrimaryKeySelectiveMapper<T> {

}
