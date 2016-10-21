package com.hp.tcp.socket;

/**
 * @author zm
 * @version 创建时间：2014-9-15 上午13:36:05
 * 类说明 网络数据结构
 */

public class NetdataStruct {

	static boolean CopyByteFromString(String src, byte[] dst, int dstBegin,int nMaxStrLen) {
		if (null == src)
			return false;

		byte temp[] = src.getBytes();
		int nCopyByte = src.length();

		if (nCopyByte > nMaxStrLen) {
			nCopyByte = nMaxStrLen;
		}
		if (nCopyByte + dstBegin < dst.length) {
			nCopyByte = dst.length - dstBegin;
			if (nCopyByte <= 0) {
				return false;
			}
		}
		System.arraycopy(temp, 0, dst, dstBegin, src.length());
		return true;
	}

	static boolean CopyByte(byte[] src, byte[] dst, int dstBegin) {
		if (null == src)
			return false;

		int nCopyByte = src.length;

		if (nCopyByte + dstBegin < dst.length) {
			nCopyByte = dst.length - dstBegin;
			if (nCopyByte <= 0) {
				return false;
			}
		}
		System.arraycopy(src, 0, dst, dstBegin, src.length);
		return true;
	}

	static boolean CopyByte(byte[] src, int srcBegin, byte[] dst, int dstBegin,int length) {
		if (null == src || null == dst)
			return false;

		int nCopyByte = length;

		if (nCopyByte + dstBegin < dst.length) {
			nCopyByte = dst.length - dstBegin;
			if (nCopyByte <= 0) {
				return false;
			}
		}
		System.arraycopy(src, 0, dst, dstBegin, src.length);
		return true;
	}

	public static boolean CopyByteFromInt(int nSrc, byte[] dst, int dstBegin) {
		if (dstBegin + 3 > dst.length) {
			return false;
		}
		dst[dstBegin + 3] = (byte) (nSrc >> 24 & 0xFF);// 在内存中低位在前，高位在后
		dst[dstBegin + 2] = (byte) (nSrc >> 16 & 0xFF);
		dst[dstBegin + 1] = (byte) (nSrc >> 8 & 0xFF);
		dst[dstBegin] = (byte) (nSrc & 0xFF);
		return true;
	}
	
	static boolean CopyByteFromLong(long nSrc, byte[] dst, int dstBegin) {
		if (dstBegin + 7 > dst.length) {
			return false;
		}
		dst[dstBegin + 7] = (byte) (nSrc >> 56 & 0xFF);// 在内存中低位在前，高位在后
		dst[dstBegin + 6] = (byte) (nSrc >> 48 & 0xFF);
		dst[dstBegin + 5] = (byte) (nSrc >> 40 & 0xFF);
		dst[dstBegin + 4] = (byte) (nSrc >> 32 & 0xFF);
		dst[dstBegin + 3] = (byte) (nSrc >> 24 & 0xFF);
		dst[dstBegin + 2] = (byte) (nSrc >> 16 & 0xFF);
		dst[dstBegin + 1] = (byte) (nSrc >> 8 & 0xFF);
		dst[dstBegin] = (byte) (nSrc & 0xFF);
		return true;
	}

	static int CopyIntFromByte(byte[] src, int srcBegin) {
		if (srcBegin + 3 > src.length) {
			return 0;
		}
		int nDst = 0;
		nDst |= (src[srcBegin + 3] & 0xFF);
		nDst = nDst << 8;
		nDst |= (src[srcBegin + 2] & 0xFF);
		nDst = nDst << 8;
		nDst |= (src[srcBegin + 1] & 0xFF);
		nDst = nDst << 8;
		nDst |= (src[srcBegin + 0] & 0xFF);
		return nDst;
	}
	
	static long CopyLongFromByte(byte[] src, int srcBegin) {
		if (srcBegin + 7 > src.length) {
			return 0;
		}
		int nDst = 0;
		nDst |= (src[srcBegin + 7] & 0xFF);
		nDst = nDst << 8;
		nDst |= (src[srcBegin + 6] & 0xFF);
		nDst = nDst << 8;
		nDst |= (src[srcBegin + 5] & 0xFF);
		nDst = nDst << 8;
		nDst |= (src[srcBegin + 4] & 0xFF);
		nDst = nDst << 8;
		nDst |= (src[srcBegin + 3] & 0xFF);
		nDst = nDst << 8;
		nDst |= (src[srcBegin + 2] & 0xFF);
		nDst = nDst << 8;
		nDst |= (src[srcBegin + 1] & 0xFF);
		nDst = nDst << 8;
		nDst |= (src[srcBegin + 0] & 0xFF);
		return nDst;
	}

	static int CopyIntFromByte(byte[] src, int srcBegin, int nBitCount) {
		if (srcBegin + nBitCount - 1 > src.length) {
			return 0;
		}
		int nDst = 0;
		for (int i = nBitCount - 1; i > 0; i--) {
			nDst |= (src[srcBegin + i] & 0xFF);
			nDst = nDst << 8;
		}
		nDst |= (src[srcBegin + 0] & 0xFF);
		return nDst;
	}

	static int CopyShortFromByte(byte[] src, int srcBegin) {
		if (srcBegin + 1 > src.length) {
			return 0;
		}
		int nDst = 0;
		nDst |= (src[srcBegin + 1] & 0xFF);
		nDst = nDst << 8;
		nDst |= (src[srcBegin + 0] & 0xFF);
		return nDst;
	}

	static boolean CopyByteFromShort(int nSrc, byte[] dst, int dstBegin) {
		if (dstBegin + 1 > dst.length) {
			return false;
		}

		dst[dstBegin + 1] = (byte) (nSrc >> 8 & 0xFF); // 在内存中低位在前，高位在后
		dst[dstBegin] = (byte) (nSrc & 0xFF);
		return true;
	}
	
	//King 2014-7-25 新增
	static boolean CopyByteFromInt8(int nSrc, byte[] dst, int dstBegin) {
		if (dstBegin + 3 > dst.length) {
			return false;
		}
		dst[dstBegin] = (byte) (nSrc & 0xFF);
		return true;
	}
	static int CopyInt8FromByte(byte[] src, int srcBegin) {
		if (srcBegin + 3 > src.length) {
			return 0;
		}
		int nDst = 0;
		nDst |= (src[srcBegin + 0] & 0xFF);
		return nDst;
	}
	
	//字节相关方法结束,包结构开始
	
	static public class NetHeader {
			/*int32_t                 nPacketSize; // NETHEAD_SIZE + nDataLen
	        uint8_t                 isZip; //数据是否压缩  0-未压缩，1-压缩
	        uint8_t                 nMainCmd; // eNetTransProtc
	        uint16_t        		nSubCmd;// exmaple eClient_GCSVR_CMD
	        int32_t                 nDataLen; //数据长度
			*/		
		
		static public int nBufferLen = 12;
		
		
		public int nPacketSize = 0;  				//包长 NETHEAD_SIZE + nDataLen
		public int isZip = 0;			//(8位)数据是否压缩  0-未压缩，1-压缩
		public int nMainCmd = 0;		//(8位) eNetTransProtc
		public int nSubCmd = 0 ;		//(16位) exmaple eClient_GCSVR_CMD
		public int nDataLen = 0;					//数据长度

		public byte[] GetBuffer() {
			byte[] buffer = new byte[nBufferLen];
			CopyByteFromInt(nPacketSize, buffer, 0);
			CopyByteFromInt8(isZip, buffer, 4);
			CopyByteFromInt8(nMainCmd, buffer, 5);
			CopyByteFromShort(nSubCmd, buffer, 6);
			CopyByteFromInt(nDataLen, buffer, 8);
			return buffer;
		}

		public void SetBuffer(byte[] bufferIn) {
			nPacketSize = CopyIntFromByte(bufferIn, 0);
			isZip = CopyInt8FromByte(bufferIn, 4);
			nMainCmd = CopyInt8FromByte(bufferIn, 5);
			nSubCmd = CopyShortFromByte(bufferIn, 6);
			nDataLen = CopyIntFromByte(bufferIn, 8);
			//DebugLog.i(TAG, "NetHeader.SetBuffer():::nMessageLength="+nMessageLength+"; nCommandID="+nCommandID);
		}
			
	}

}
