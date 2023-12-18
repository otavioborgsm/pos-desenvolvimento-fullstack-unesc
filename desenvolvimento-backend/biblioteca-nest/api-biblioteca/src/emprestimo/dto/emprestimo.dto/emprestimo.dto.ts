import { IsDate, IsNumber } from 'class-validator';

export class EmprestimoDto {
  @IsNumber()
  id: number;

  @IsNumber()
  idUsuario: number;

  @IsNumber()
  idLivro: number;

  @IsDate()
  dtEmprestimo: Date;

  @IsDate()
  dtDevolucao: Date;
}
