import { Column, Entity, PrimaryGeneratedColumn } from 'typeorm';

@Entity()
export class EmprestimoEntity {
  @PrimaryGeneratedColumn()
  id: number;

  @Column({ nullable: false })
  idUsuario: number;

  @Column({ nullable: false })
  idLivro: number;

  @Column({ nullable: false })
  dtEmprestimo: Date;

  @Column({ nullable: false })
  dtDevolucao: Date;
}
