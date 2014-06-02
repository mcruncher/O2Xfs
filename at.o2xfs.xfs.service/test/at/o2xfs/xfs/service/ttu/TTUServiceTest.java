/*
 * Copyright (c) 2014, Andreas Fagschlunger. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 * 
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package at.o2xfs.xfs.service.ttu;

import org.junit.Test;

import at.o2xfs.xfs.WFSResult;
import at.o2xfs.xfs.service.XfsCommandTest;
import at.o2xfs.xfs.service.XfsService;
import at.o2xfs.xfs.service.cmd.XfsCommand;
import at.o2xfs.xfs.service.cmd.XfsInfoCommand;
import at.o2xfs.xfs.ttu.TTUInfoCommand;
import at.o2xfs.xfs.ttu.WFSTTUSTATUS;

public class TTUServiceTest extends XfsCommandTest {

	private XfsService ttuService = null; // FIXME

	@Test
	public void status() throws Exception {
		XfsCommand xfsCommand = new XfsInfoCommand(ttuService,
				TTUInfoCommand.WFS_INF_TTU_STATUS);
		WFSResult wfsResult = null;
		try {
			wfsResult = xfsCommand.call();
			WFSTTUSTATUS ttuStatus = new WFSTTUSTATUS(wfsResult.getResults());
			System.out.println(ttuStatus);
		} finally {
			if (wfsResult != null) {
				xfsServiceManager.free(wfsResult);
			}
		}
	}
}