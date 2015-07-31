package io.mycat.route.function;

import io.mycat.server.config.RuleAlgorithm;

import java.util.zip.CRC32;

/**
 * Author: shusl
 * Date:   15/7/31 19:10
 */
public class PartitionByStringCRC32Mod extends PartitionByMod {
	@Override
	public Integer calculate(String columnValue) {
		CRC32 crc32 = new CRC32();
		crc32.update(columnValue.getBytes());
		return (int)(crc32.getValue() % count)  ;
	}
}
