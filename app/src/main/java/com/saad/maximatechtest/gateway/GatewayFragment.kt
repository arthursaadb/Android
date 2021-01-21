package com.saad.maximatechtest.gateway

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.saad.maximatechtest.R
import com.saad.maximatechtest.databinding.FragmentGatewayBinding
import com.saad.maximatechtest.utils.AppConnectivityManager

class GatewayFragment : Fragment(), GatewayContract.View {
    private var _binding: FragmentGatewayBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: GatewayContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGatewayBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initPresenter()
        setupGatewayOptionsClick()
    }

    private fun initPresenter() {
        presenter = GatewayPresenter(this, AppConnectivityManager(requireContext()))
    }

    override fun goToClientData() {
    }

    override fun goToRequests() {
    }

    override fun goToSalesSummary() {
    }

    override fun goToTools() {
    }

    override fun showIconWithConnection() {
        binding.iconInternet.setImageResource(R.drawable.ic_maxima_nuvem_conectado)
    }

    override fun showIconWithoutConnection() {
        binding.iconInternet.setImageResource(R.drawable.ic_maxima_nuvem_desconectado)
    }

    override fun onResume() {
        super.onResume()

        presenter.validateConnection()
    }

    private fun setupGatewayOptionsClick() {
        binding.cardClients.setOnClickListener { presenter.onClickCardClients() }
        binding.cardRequests.setOnClickListener { presenter.onClickCardRequest() }
        binding.cardSalesSummary.setOnClickListener { presenter.onClickCardSalesSummary() }
        binding.cardTools.setOnClickListener { presenter.onClickCardTools() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            GatewayFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}