provider "aws" { region = "ap-south-1" }
module "eks_mumbai" {
  source  = "terraform-aws-modules/eks/aws"
  version = "19.21.0"
  cluster_name    = "messenger-mumbai"
  cluster_version = "1.30"
  vpc_id          = aws_vpc.main.id
  subnets         = aws_subnet.private[*].id
  eks_managed_node_groups = {
    realtime = {
      capacity_type = "ON_DEMAND"
      instance_types = ["c7g.4xlarge"]
      min_size = 3
      max_size = 30
      desired_size = 6
      labels = { workload = realtime }
      taints = [{ key = realtime, value = "true", effect = "NO_SCHEDULE" }]
    }
  }
}