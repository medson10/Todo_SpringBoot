<template>
  <div class="container" id="app">
      <div class="row">
          <form class="col-md-6 col-md-offset-1">
              <div class="form-group">
                  <label for="nome">Nome</label>
                  <input type="text" class="form-control" id="nome" placeholder="Digite o nome"
                         v-model="member.name">
              </div>
              <div class="form-group">
                  <label for="idade">Idade</label>
                  <input type="text" class="form-control" id="idade" placeholder="Digite a idade"
                         v-model="member.age">
              </div>

              <button type="button" class="btn btn-primary"
                      v-on:click="">
                  Salvar
              </button>

              <button type="button" class="btn btn-danger">
                      Cancelar
              </button>
          </form>

          <div class="col-md-6 col-md-offset-3 group-form">
              <label for="search">Pesquisar</label>
              <input type="text" id="search" class="form-control" placeholder="Pesquisar Colaborador">
          </div>

          <div class="col-md-6 col-md-offset-1">
              <table class="table table-hover">
                  <thead>
                      <tr>
                          <th>Nome</th>
                          <th>Idade</th>
                          <th></th>
                          <th></th>
                      </tr>
                  </thead>
                  <tbody>
                       <tr v-for="m in members">
                          <td >{{m.name}}</td>
                          <td >{{m.age}}</td>
                          <td>
                              <button type="button" name="editar" class="btn btn-warning">
                                  Editar
                              </button>
                          </td>
                          <td>
                              <button type="button" name="cancelar" class="btn btn-danger">
                                  Excluir
                              </button>
                          </td>
                      </tr>
                  </tbody>
              </table>
          </div>

      </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      member: {
          name: '',
          age: ''
      },
      members: []
    }
  },
  methods: {
      getMembers() {
          this.$http.get('https://todo-spring-boot.herokuapp.com/member', (data) => {
              this.data.members = data;
              console.log(this.data.members);
          })
          .then((d) => {
              console.log(d);
          })
          .catch((e) => {
              console.log(e);
          });
      },
      saveMember(member) {
          this.$http.post('https://todo-spring-boot.herokuapp.com/member', member);
      }
      //editMember -> this.$http.put('rota/:id', member)
      //deleteMember -> this.$http.delete('rota/:id')
  }
}
</script>
