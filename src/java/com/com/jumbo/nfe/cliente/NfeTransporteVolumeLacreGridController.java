/*
 * The MIT License
 * 
 * Copyright: Copyright (C) 2014 T2Ti.COM
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * The author may be contacted at: t2ti.com@gmail.com
 *
 * @author Claudio de Barros (T2Ti.com)
 * @version 2.0
 */
package com.com.jumbo.nfe.cliente;

import com.com.jumbo.nfe.java.NfeTransporteVolumeLacreVO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;
import org.openswing.swing.util.java.Consts;

public class NfeTransporteVolumeLacreGridController extends GridController implements GridDataLocator {

    private NfeDetalhe nfeDetalhe;
    private List<NfeTransporteVolumeLacreVO> transporteVolumeLacre;

    public NfeTransporteVolumeLacreGridController(NfeDetalhe nfeDetalhe) {
        this.nfeDetalhe = nfeDetalhe;
    }

    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        if (transporteVolumeLacre != null) {
            return new VOListResponse(transporteVolumeLacre, false, transporteVolumeLacre.size());
        } else {
            return new VOListResponse();
        }
    }

    @Override
    public boolean beforeInsertGrid(GridControl grid) {
        if (nfeDetalhe.getGridControlTransporteVolume().getSelectedRow() != -1) {
            if (nfeDetalhe.getFormDadosNfe().getMode() == Consts.READONLY) {
                nfeDetalhe.getFormDadosNfe().setMode(Consts.EDIT);
            }
            return true;
        }
        JOptionPane.showMessageDialog(nfeDetalhe, "Selecione um Volume!", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
        return false;
    }

    @Override
    public Response insertRecords(int[] rowNumbers, ArrayList newValueObjects) throws Exception {
        for (int i = 0; i < newValueObjects.size(); i++) {
            transporteVolumeLacre.add((NfeTransporteVolumeLacreVO) newValueObjects.get(i));
        }

        return new VOListResponse(newValueObjects, false, newValueObjects.size());
    }

    @Override
    public boolean beforeEditGrid(GridControl grid) {
        if (nfeDetalhe.getFormDadosNfe().getMode() == Consts.READONLY) {
            nfeDetalhe.getFormDadosNfe().setMode(Consts.EDIT);
        }
        return true;
    }

    @Override
    public Response updateRecords(int[] rowNumbers, ArrayList oldPersistentObjects, ArrayList persistentObjects) throws Exception {
        for (int i = 0; i < persistentObjects.size(); i++) {
            transporteVolumeLacre.set(rowNumbers[i], (NfeTransporteVolumeLacreVO) persistentObjects.get(i));
        }
        return new VOListResponse(persistentObjects, false, persistentObjects.size());
    }

    @Override
    public boolean beforeDeleteGrid(GridControl grid) {
        if (nfeDetalhe.getFormDadosNfe().getMode() == Consts.READONLY) {
            nfeDetalhe.getFormDadosNfe().setMode(Consts.EDIT);
        }
        return true;
    }

    @Override
    public Response deleteRecords(ArrayList persistentObjects) throws Exception {
        for (int i = 0; i < persistentObjects.size(); i++) {
            transporteVolumeLacre.remove(persistentObjects.get(i));
        }
        return new VOListResponse(persistentObjects, false, persistentObjects.size());
    }

    public void setTransporteVolumeLacre(List<NfeTransporteVolumeLacreVO> transporteVolumeLacre) {
        this.transporteVolumeLacre = transporteVolumeLacre;
    }
}
