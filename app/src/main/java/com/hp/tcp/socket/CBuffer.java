package com.hp.tcp.socket;

/**
 * @author shou_peng
 * @version 创建时间：2012-9-3 上午09:29:53 类说明
 */

public class CBuffer {

	public byte m_buffer[];
	public int m_nBufferLen;
	public int m_nStartPos;
	public int m_nEndPos;

	public CBuffer() {
		m_buffer = null;
		m_nBufferLen = 0;
		m_nStartPos = 0;
		m_nEndPos = 0;
	}

	public CBuffer(byte[] bufferIn) {
		m_buffer = new byte[bufferIn.length];
		m_nBufferLen = bufferIn.length;
		System.arraycopy(m_buffer, 0, bufferIn, 0, bufferIn.length);

		m_nStartPos = 0;
		m_nEndPos = bufferIn.length;
	}

	public CBuffer(int nSize) {
		m_buffer = new byte[nSize];
		m_nBufferLen = nSize;
		m_nStartPos = 0;
		m_nEndPos = 0;
	}

	public CBuffer(CBuffer bufferIn) {
		m_buffer = new byte[bufferIn.m_nBufferLen];
		m_nBufferLen = bufferIn.m_nBufferLen;
		m_nStartPos = bufferIn.m_nStartPos;
		m_nEndPos = bufferIn.m_nEndPos;
		System.arraycopy(bufferIn.m_buffer, 0, m_buffer, 0,
				bufferIn.m_nBufferLen);
	}

	public void Attach(byte[] buffer) {
		m_buffer = buffer;
		m_nBufferLen = buffer.length;
		m_nStartPos = 0;
		m_nEndPos = buffer.length;
	}

	byte[] GetBuffer() {
		return m_buffer;
	}

	byte[] GetRealBuffer() {
		byte[] realBuffer = new byte[m_nEndPos - m_nStartPos];
		System.arraycopy(m_buffer, m_nStartPos, realBuffer, 0,
				realBuffer.length);
		return realBuffer;
	}

	public int GetBufferLen() {
		return m_nBufferLen;
	}

	int GetRealLen() {
		return m_nEndPos - m_nStartPos;
	}

	void SetPos(int nStart, int nEnd) {
		m_nStartPos = nStart;
		m_nEndPos = nEnd;
	}

}
