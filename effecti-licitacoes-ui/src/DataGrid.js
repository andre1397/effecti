import React, { Component } from 'react';
import { DataTable } from 'primereact/datatable';
import { classNames } from 'primereact/utils';
import { Column } from 'primereact/column';
import { Dropdown } from 'primereact/dropdown';

export class DataTableGridLinesDemo extends Component {

    constructor(props) {
          super(props);

         this.state = {
             licitacoes: null,
             selectedLicitacoes: null,
             globalFilter: null,
             selectedLocalizacoes: null,
             selectedStatus: null
           };

      this.statuses = [
        'JULGADO - HOMOLOGADO', 'JULGADO - PENDENTE DE HOMOLOGAÇÃO/RESUMO DE EMPENHO'
    ];

        //body cells
        this.licitacaoBodyTemplate = this.licitacaoBodyTemplate.bind(this);
        this.statusBodyTemplate = this.statusBodyTemplate.bind(this);
        this.visualizarBodyTemplate = this.visualizarBodyTemplate.bind(this);
        this.itensBodyTemplate = this.itensBodyTemplate.bind(this);
        this.baixarBodyTemplate = this.baixarBodyTemplate.bind(this);

        //filters
        this.statusItemTemplate = this.statusItemTemplate.bind(this);
        this.onStatusFilterChange = this.onStatusFilterChange.bind(this);
    }

      componentDidMount() {
        const url = "http://" + window.location.hostname + ":8080/api/effecti";

        fetch(url)
        .then((resultado) => resultado.json())
        .then(
            resultado => { this.setState({licitacoes : resultado})}
            )
        .catch(function() {

        });
    }

    statusBodyTemplate(rowData) {
        return (
            <React.Fragment>
                <span className={classNames('licitacao-status', 'status-' + rowData.status)}>{rowData.status}</span>
            </React.Fragment>
        );
    }

    visualizarBodyTemplate(rowData) {
        return (
            <React.Fragment>
                <span className="p-column-title"></span>
                <a href={rowData.arquivoVisualizar} target="_blank" className={classNames('licitacao-visualizar', 'visualizar-' + rowData.arquivoVisualizar)}>Vizualizar Arquivo</a>
            </React.Fragment>
        );
    }

    itensBodyTemplate(rowData) {
        return (
            <React.Fragment>
                <span className="p-column-title"></span>
                <a href={rowData.arquivoItens} target="_blank" className={classNames('licitacao-itens', 'itens-' + rowData.arquivoVisualizar)}>Visualizar itens da Ata</a>
            </React.Fragment>
        );
    }

    baixarBodyTemplate(rowData) {
        return (
            <React.Fragment>
                <span className="p-column-title"></span>
                <a href={rowData.arquivoBaixar} target="_blank" className={classNames('licitacao-baixar', 'baixar-' + rowData.arquivoVisualizar)}>Baixar Arquivo</a>
            </React.Fragment>
        );
    }

    licitacaoBodyTemplate(rowData) {
        return (
            <React.Fragment>
                {rowData.licitacao}
            </React.Fragment>
        );
    }

    renderStatusFilter() {
        return (
            <Dropdown value={this.state.selectedStatus} options={this.statuses} onChange={this.onStatusFilterChange}
            itemTemplate={this.statusItemTemplate} showClear placeholder="Selecione um Status" className="p-column-filter"/>
        );
    }

    statusItemTemplate(option) {
        return (
            <span className={classNames('licitacao-status', 'status-' + option)}>{option}</span>
        );
    }

    onStatusFilterChange(event) {
        this.dt.filter(event.value, 'status', 'equals');
        this.setState({selectedStatus: event.value});
    }

     render() {
        const statusFilter = this.renderStatusFilter();
        return (
               <div>
                <div className="card">
                       <DataTable ref={(el) => this.dt = el} value={this.state.licitacoes} header="Atas de Solicitação de Registro de Preço Vigentes" showGridlines
                            selection={this.state.selectedLicitacoes} onSelectionChange={e => this.setState({selectedLicitacoes: e.value})}
                            paginator rows={10} emptyMessage="Nenhuma licitação encontrada" currentPageReportTemplate="Showing {first} to {last} of {totalRecords} entries"
                            paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown" rowsPerPageOptions={[10,25,50]}>
                            <Column selectionMode="multiple" header="Marcar como lido" style={{width:'7em'}}/>
                            <Column field="licitacao" header="Licitação" body={this.licitacaoBodyTemplate} sortable filter filterPlaceholder="Search by licitacao"></Column>
                            <Column field="status" header="Status" body={this.statusBodyTemplate} sortable filter filterElement={statusFilter}></Column>
                            <Column field="localizacao" header="Localização" body={this.localizacaoBodyTemplate}></Column>
                            <Column field="vigencia" header="Vigência" body={this.vigenciaBodyTemplate} sortable></Column>
                            <Column field="descricao" header="Descrição" body={this.descricaoBodyTemplate}></Column>
                            <Column field= "arquivoVisualizar" header="Visualizar" body={this.visualizarBodyTemplate}></Column>
                            <Column field="arquivoItens" header="Itens" body={this.itensBodyTemplate}></Column>
                            <Column field="arquivoBaixar" header="Baixar" body={this.baixarBodyTemplate}></Column>
                        </DataTable>
                    </div>
                </div>
            );
        }
    }
