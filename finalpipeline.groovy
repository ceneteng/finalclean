node {
    
    stage('Clone sources') {
        git url: 'https://github.com/ceneteng/final.git'
    }

    stage('Run playbook'){

        ansiblePlaybook installation: 'Ansible', inventory: 'inventory/ansible_nodes', playbook: 'createTestSecGroups.yml'

        }
    stage('Run playbook'){

        ansiblePlaybook installation: 'Ansible', inventory: 'inventory/ansible_nodes', playbook: 'createDevSecGroups.yml'

        }   
    
     stage('Run playbook'){

        ansiblePlaybook installation: 'Ansible', inventory: 'inventory/ansible_nodes', playbook: 'createProdSecGroups.yml'

        }
    stage('Run playbook'){

        ansiblePlaybook installation: 'Ansible', inventory: 'inventory/ansible_nodes', playbook: 'DevLBandAS.yml'

        }
    stage('Run playbook'){

        ansiblePlaybook installation: 'Ansible', inventory: 'inventory/ansible_nodes', playbook: 'ProdLBandAS.yml'

        }   
    
     stage('Run playbook'){

        ansiblePlaybook installation: 'Ansible', inventory: 'inventory/ansible_nodes', playbook: 'TestLBandAS.yml'

        }
        
}
